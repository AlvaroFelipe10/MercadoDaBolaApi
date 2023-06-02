package com.mercadodabola.mercadotransferencia.domain.converters.impl;

import org.springframework.stereotype.Component;

import com.mercadodabola.mercadotransferencia.domain.converters.ClubeConverter;
import com.mercadodabola.mercadotransferencia.domain.dtos.ClubeDto;
import com.mercadodabola.mercadotransferencia.domain.entities.JogadorEntity;

@Component
public class ClubeConverterImpl implements ClubeConverter {

	
	public ClubeDto listaGolAssistencia(JogadorEntity jogadorEntity) {
		ClubeDto retorno = ClubeDto.builder()
				.nome(jogadorEntity.getNome())
				.gols(null)
				.assistencias(null)
				.build();
		
		return retorno;
	}

}
