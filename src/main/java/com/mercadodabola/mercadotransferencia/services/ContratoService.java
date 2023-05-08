package com.mercadodabola.mercadotransferencia.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mercadodabola.mercadotransferencia.domain.converters.impl.JogadorConverterImpl;
import com.mercadodabola.mercadotransferencia.domain.dtos.JogadorListDto;
import com.mercadodabola.mercadotransferencia.domain.dtos.TransferenciaJogadorDto;
import com.mercadodabola.mercadotransferencia.domain.entities.ClubeEntity;
import com.mercadodabola.mercadotransferencia.domain.entities.ContratoEntity;
import com.mercadodabola.mercadotransferencia.domain.entities.JogadorEntity;
import com.mercadodabola.mercadotransferencia.domain.exception.ContratoNaoEncontradoException;
import com.mercadodabola.mercadotransferencia.domain.exception.JogadorNaoEncontradoException;
import com.mercadodabola.mercadotransferencia.domain.exception.NegocioException;
import com.mercadodabola.mercadotransferencia.repositories.ClubeRepository;
import com.mercadodabola.mercadotransferencia.repositories.ContratoRepository;
import com.mercadodabola.mercadotransferencia.repositories.JogadorRepository;

@Service
public class ContratoService {

	private static final String MSG_CONTRATO_NAO_ENCONTRADO = "Não existe um cadastro de contrato com id %d";

	private static final String MSG_CADASTRO_NAO_ENCONTRADO = "O jogador não tem nenhum contrato vigente";

	private static final String MSG_JOGADOR_NAO_ENCONTRADO = "O jogador com id %d não foi encontrado";

	private static final String MSG_LIMITE_MAXIMO_CONTRATOS = "Não podemos fazer essa transferencia, pois o clube ja atigiu seu limite de 23 jogadores";
	
	private static final String MSG_REGRA_MULTA_TRANSFERENCIA = "Não foi posivel realizar a transferência pois o valor da multa é maior que o valor da transferência";

	@Autowired
	private ContratoRepository contratoRepository;

	@Autowired
	private JogadorRepository jogadorRepository;

	@Autowired
	private ClubeRepository clubeRepository;
	
	@Autowired 
	private JogadorConverterImpl jogadorConverter;

	public TransferenciaJogadorDto transferir(TransferenciaJogadorDto transferenciaJogadorDto) {

		this.validaContratosMaximosEmUmClube(transferenciaJogadorDto);

		JogadorEntity jogadorEntity = this.validaSeJogadorExiste(transferenciaJogadorDto);

		ContratoEntity contratoEntity = contratoRepository.findByJogadorId(transferenciaJogadorDto.getJogadorId());

		if (contratoEntity != null) {
			if (this.validaSeTransferenciaMaiorQueMulta(transferenciaJogadorDto, contratoEntity)) {
				jogadorEntity.setContrato(null);
				jogadorRepository.save(jogadorEntity);
				contratoRepository.deleteById(contratoEntity.getId());
			}
		}

		ContratoEntity contratoNovo = inserirContrato(transferenciaJogadorDto, contratoEntity, jogadorEntity);
		jogadorEntity.setContrato(contratoNovo);
		jogadorRepository.save(jogadorEntity);
		return transferenciaJogadorDto;

	}

	private boolean validaSeTransferenciaMaiorQueMulta(TransferenciaJogadorDto transferenciaJogadorDto,
			ContratoEntity contratoEntity) {
		if (transferenciaJogadorDto.getValorDaTransferencia().compareTo(contratoEntity.getValorMulta()) == -1) {
			throw new NegocioException(MSG_REGRA_MULTA_TRANSFERENCIA);
		}
		return true;
	}

	private void validaContratosMaximosEmUmClube(TransferenciaJogadorDto transferenciaJogadorDto) {
		int qtdContratosClube = contratoRepository.countByClubeId(transferenciaJogadorDto.getClubeDestinoId());
		if (qtdContratosClube > 23) {
			throw new NegocioException(MSG_LIMITE_MAXIMO_CONTRATOS);
		}
	}

	private JogadorEntity validaSeJogadorExiste(TransferenciaJogadorDto transferenciaJogadorDto) {
		return jogadorRepository.findById(transferenciaJogadorDto.getJogadorId())
				.orElseThrow(() -> new JogadorNaoEncontradoException(
						String.format(MSG_JOGADOR_NAO_ENCONTRADO, transferenciaJogadorDto.getJogadorId())));
	}

	private ContratoEntity inserirContrato(TransferenciaJogadorDto transferenciaJogadorDto,
											ContratoEntity contratoEntity, JogadorEntity jogadorEntity) {
		ContratoEntity contratoNovo = new ContratoEntity();
		ClubeEntity clubeDestino = clubeRepository.findById(transferenciaJogadorDto.getClubeDestinoId()).get();
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
			this.clubeRepository.save(clubeOrigem);
		}

		return contratoRepository.save(contratoNovo);
	}
	
	public List<JogadorListDto> listarPorOrdemSalarioMaisAlto(){
		List<JogadorListDto> retorno = new ArrayList<>();
		List<ContratoEntity> contratoEntity = contratoRepository.porOrdemSalarioMaior();
		contratoEntity.forEach(contrato -> {
			JogadorListDto dto = jogadorConverter.listToJogadorDto(contrato.getJogador());
			retorno.add(dto);
		});
		return retorno;
	}
	
	public List<JogadorListDto> listarPorOrdemSalarioMaisBaixo(){
		List<JogadorListDto> retorno = new ArrayList<>();
		List<ContratoEntity> contratoEntity = contratoRepository.porOrdemSalarioMenor();
		contratoEntity.forEach(contrato -> {
			JogadorListDto dto = jogadorConverter.listToJogadorDto(contrato.getJogador());
			retorno.add(dto);
		});
		return retorno;
	}
	
	public List<JogadorListDto> listarPorOrdemSalario(String order){
		List<JogadorListDto> retorno = new ArrayList<>();
		
		Sort sort = (order.equals("desc")) ? Sort.by("salario").descending() : Sort.by("salario").ascending();
		
		Pageable sortedBySalario = 
				  PageRequest.of(0, 10, sort);
		Page<ContratoEntity> listEntity = contratoRepository.findAll(sortedBySalario);
			listEntity.forEach(contrato -> { 
			JogadorListDto dto = jogadorConverter.listToJogadorDto(contrato.getJogador());
		retorno.add(dto);
		});
		return retorno ;
	}
	
	
	public Optional<ContratoEntity> buscarOuFalhar(Long contratoId) {
		return Optional.ofNullable(contratoRepository.findById(contratoId).orElseThrow(
				() -> new ContratoNaoEncontradoException(String.format(MSG_CONTRATO_NAO_ENCONTRADO, contratoId))));
	}

}
