package com.mercadodabola.mercadotransferencia.domain.converters.impl;


import org.springframework.stereotype.Component;

import com.mercadodabola.mercadotransferencia.domain.converters.CampeonatoConverter;
import com.mercadodabola.mercadotransferencia.domain.dtos.CampeonatoTabelaDto;
import com.mercadodabola.mercadotransferencia.domain.entities.ClubeEntity;

@Component
public class CampeonatoConverterImpl implements CampeonatoConverter {


	@Override
	public CampeonatoTabelaDto tabelaCampeonato(ClubeEntity clubeEntity) {
		CampeonatoTabelaDto dto = CampeonatoTabelaDto.builder()
				.nome(clubeEntity.getNome())
				.build();
		return dto;
	}
}


