package com.mercadodabola.mercadotransferencia.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercadodabola.mercadotransferencia.domain.dtos.TransferenciaJogadorDto;
import com.mercadodabola.mercadotransferencia.domain.entities.ClubeEntity;
import com.mercadodabola.mercadotransferencia.domain.entities.ContratoEntity;
import com.mercadodabola.mercadotransferencia.domain.entities.JogadorEntity;
import com.mercadodabola.mercadotransferencia.domain.exception.ClubeNaoEncontradoException;
import com.mercadodabola.mercadotransferencia.domain.exception.ContratoNaoEncontradoException;
import com.mercadodabola.mercadotransferencia.domain.exception.JogadorNaoEncontradoException;
import com.mercadodabola.mercadotransferencia.repositories.ClubeRepository;
import com.mercadodabola.mercadotransferencia.repositories.ContratoRepository;
import com.mercadodabola.mercadotransferencia.repositories.JogadorRepository;

@Service
public class ContratoService {

	private static final String MSG_CONTRATO_NAO_ENCONTRADO = "Não existe um cadastro de contrato com id %d";

	private static final String MSG_CADASTRO_NAO_ENCONTRADO = "O jogador não tem nenhum contrato vigente";
	
	private static final String MSG_JOGADOR_NAO_ENCONTRADO = "O jogador com id %d não foi encontrado";

	@Autowired
	private ContratoRepository contratoRepository;

	@Autowired
	private JogadorRepository jogadorRepository;

	@Autowired
	private ClubeRepository clubeRepository;

	public void transferir(TransferenciaJogadorDto transferenciaJogadorDto) {
		Long jogadorId = transferenciaJogadorDto.getJogadorId();
		JogadorEntity jogador = jogadorRepository.findById(jogadorId).orElseThrow(() -> new JogadorNaoEncontradoException(String.format(MSG_JOGADOR_NAO_ENCONTRADO, jogadorId)));
		ContratoEntity contratoEntity = contratoRepository.findByJogadorId(transferenciaJogadorDto.getJogadorId());
		JogadorEntity jogadorEntity = jogadorRepository.findById(transferenciaJogadorDto.getJogadorId()).get();
		
		
		ContratoEntity contratoNovo = null;
		
		if (contratoEntity == null) {
			contratoNovo = inserirContrato(transferenciaJogadorDto, contratoEntity);

		} else {
			if (transferenciaJogadorDto.getValorDaTransferencia().compareTo(contratoEntity.getValorMulta()) == 1) {
				jogadorEntity.setContrato(null);
				jogadorRepository.save(jogadorEntity);
				Long contratoId = contratoEntity.getId();
				contratoRepository.deleteById(contratoId);
				contratoNovo = inserirContrato(transferenciaJogadorDto, contratoEntity);
			}
		}
		jogadorEntity.setContrato(contratoNovo);
		jogadorRepository.save(jogadorEntity);
	}

	private ContratoEntity inserirContrato(TransferenciaJogadorDto transferenciaJogadorDto,
			ContratoEntity contratoEntity) {
		ContratoEntity contratoNovo = new ContratoEntity();
		JogadorEntity jogadorEntity = jogadorRepository.findById(transferenciaJogadorDto.getJogadorId()).get();
		ClubeEntity clubeDestino = clubeRepository.findById(transferenciaJogadorDto.getClubeDestinoId()).get();
//		ClubeEntity clubeOrigem = clubeRepository.findById(contratoNovo.getClube().getId()).get();
		contratoNovo.setClube(clubeDestino);
		clubeDestino.setCaixa(clubeDestino.getCaixa().subtract(transferenciaJogadorDto.getValorDaTransferencia()));
		contratoNovo.setDataInicio(transferenciaJogadorDto.getDataInicio());
		contratoNovo.setDataTermino(transferenciaJogadorDto.getDataTermino());
		contratoNovo.setJogador(jogadorEntity);
		contratoNovo.setSalario(transferenciaJogadorDto.getSalario());
		contratoNovo.setValorMulta(transferenciaJogadorDto.getMulta());
		if (contratoEntity != null) {
			ClubeEntity clubeOrigem = clubeRepository.findById(contratoEntity.getClube().getId()).get();
			clubeOrigem.setCaixa(clubeOrigem.getCaixa().add(transferenciaJogadorDto.getValorDaTransferencia()));
		}
		return contratoRepository.save(contratoNovo);
	}

	public Optional<ContratoEntity> buscarOuFalhar(Long contratoId) {
		return Optional.ofNullable(contratoRepository.findById(contratoId).orElseThrow(
				() -> new ContratoNaoEncontradoException(String.format(MSG_CONTRATO_NAO_ENCONTRADO, contratoId))));
	}

}
