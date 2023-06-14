package com.mercadodabola.mercadotransferencia.domain.converters.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mercadodabola.mercadotransferencia.domain.converters.GolsAssistenciasConverter;
import com.mercadodabola.mercadotransferencia.domain.dtos.GolsAssistenciasDto;
import com.mercadodabola.mercadotransferencia.domain.entities.GolAssistPartidaEntity;
import com.mercadodabola.mercadotransferencia.repositories.GolAssistPartidaRepository;

@Component
public class GolsAssistenciasImpl implements GolsAssistenciasConverter{

	@Autowired
	private GolAssistPartidaRepository golAssistRepository;
	
	public GolsAssistenciasDto listaGolsAssistencias(GolAssistPartidaEntity golAssist) {
		GolsAssistenciasDto retorno = GolsAssistenciasDto.builder()
				.nomeJogador(golAssist.getIdJogador().getNome())
				.gol(golAssist.getTipoLance().GOL)
				.assistencia(golAssist.getTipoLance().ASSISTENCIA)
				.build();
		
		return retorno;
	}

}
