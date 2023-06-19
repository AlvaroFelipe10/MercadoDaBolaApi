package com.mercadodabola.mercadotransferencia.domain.converters.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mercadodabola.mercadotransferencia.domain.converters.ClubeConverter;
import com.mercadodabola.mercadotransferencia.domain.dtos.ClubeDto;
import com.mercadodabola.mercadotransferencia.domain.entities.JogadorEntity;
import com.mercadodabola.mercadotransferencia.repositories.GolAssistPartidaRepository;

@Component
public class ClubeConverterImpl implements ClubeConverter {

	@Autowired
	GolAssistPartidaRepository golAssistRepository;

	
	public ClubeDto listaClubeDto(JogadorEntity jogadorEntity) {
		ClubeDto retorno = ClubeDto.builder()
				.nome(jogadorEntity.getNome())
				.build();
		retorno.setGolsClube(golAssistRepository.listaGolsClube(jogadorEntity.getContrato().getClube().getId(), jogadorEntity.getId()));
		return retorno;
	}
	

}
