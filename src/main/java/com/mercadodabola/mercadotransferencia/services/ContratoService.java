package com.mercadodabola.mercadotransferencia.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercadodabola.mercadotransferencia.domain.dtos.TransferenciaJogadorDto;
import com.mercadodabola.mercadotransferencia.domain.entities.ContratoEntity;
import com.mercadodabola.mercadotransferencia.domain.exception.ContratoNaoEncontradoException;
import com.mercadodabola.mercadotransferencia.repositories.ContratoRepository;

@Service
public class ContratoService {
	
	private static final String MSG_CONTRATO_NAO_ENCONTRADO = 
	        "Não existe um cadastro de contrato com id %d";
	
	@Autowired
	private ContratoRepository contratoRepository;
	
	public void transferir(TransferenciaJogadorDto transferenciaJogadorDto) {
		
	}
	
	public Optional<ContratoEntity> buscarOuFalhar(Long contratoId) {
		return Optional.ofNullable(contratoRepository.findById(contratoId)
				.orElseThrow(() -> new ContratoNaoEncontradoException(String.format(MSG_CONTRATO_NAO_ENCONTRADO, contratoId))));
	}

}
