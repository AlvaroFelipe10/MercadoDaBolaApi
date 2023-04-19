package com.mercadodabola.mercadotransferencia.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercadodabola.mercadotransferencia.domain.dtos.TransferenciaJogadorDto;
import com.mercadodabola.mercadotransferencia.domain.entities.ClubeEntity;
import com.mercadodabola.mercadotransferencia.domain.entities.ContratoEntity;
import com.mercadodabola.mercadotransferencia.domain.entities.JogadorEntity;
import com.mercadodabola.mercadotransferencia.domain.exception.ContratoNaoEncontradoException;
import com.mercadodabola.mercadotransferencia.repositories.ClubeRepository;
import com.mercadodabola.mercadotransferencia.repositories.ContratoRepository;
import com.mercadodabola.mercadotransferencia.repositories.JogadorRepository;

@Service
public class ContratoService {

	private static final String MSG_CONTRATO_NAO_ENCONTRADO = "Não existe um cadastro de contrato com id %d";

	private static final String MSG_CADASTRO_NAO_ENCONTRADO = "O jogador não tem nenhum contrato vigente";

	@Autowired
	private ContratoRepository contratoRepository;

	@Autowired
	private JogadorRepository jogadorRepository;
	
	@Autowired
	private ClubeRepository clubeRepository;

	public void transferir(TransferenciaJogadorDto transferenciaJogadorDto) {

		ContratoEntity contratoEntity = contratoRepository.findByJogadorId(transferenciaJogadorDto.getJogadorId());
		if (contratoEntity == null) {
//				throw new NegocioException(MSG_CADASTRO_NAO_ENCONTRADO);
		} else {
			if (transferenciaJogadorDto.getValorDaTransferencia().compareTo(contratoEntity.getValorMulta()) == 1) {
				JogadorEntity jogadorEntity = jogadorRepository.findById(transferenciaJogadorDto.getJogadorId()).get();
				jogadorEntity.setContrato(null);
				jogadorRepository.save(jogadorEntity);
				Long contratoId = contratoEntity.getId();
				contratoRepository.deleteById(contratoId);
				
				ContratoEntity contratoNovo = inserirContrato(transferenciaJogadorDto);
				jogadorEntity.setContrato(contratoNovo);
				jogadorRepository.save(jogadorEntity);
			}
		}

	}
	
	private ContratoEntity inserirContrato(TransferenciaJogadorDto transferenciaJogadorDto) {
		ContratoEntity contratoEntity = new ContratoEntity();
		JogadorEntity jogadorEntity = jogadorRepository.findById(transferenciaJogadorDto.getJogadorId()).get();
		ClubeEntity clubeEntity = clubeRepository.findById(transferenciaJogadorDto.getClubeDestinoId()).get();
		
		contratoEntity.setClube(clubeEntity);
		contratoEntity.setDataInicio(transferenciaJogadorDto.getDataInicio());
		contratoEntity.setDataTermino(transferenciaJogadorDto.getDataTermino());
		contratoEntity.setJogador(jogadorEntity);
		contratoEntity.setSalario(transferenciaJogadorDto.getSalario());
		contratoEntity.setValorMulta(transferenciaJogadorDto.getMulta());
		return contratoRepository.save(contratoEntity);
	}
	
	

	public Optional<ContratoEntity> buscarOuFalhar(Long contratoId) {
		return Optional.ofNullable(contratoRepository.findById(contratoId).orElseThrow(
				() -> new ContratoNaoEncontradoException(String.format(MSG_CONTRATO_NAO_ENCONTRADO, contratoId))));
	}

}
