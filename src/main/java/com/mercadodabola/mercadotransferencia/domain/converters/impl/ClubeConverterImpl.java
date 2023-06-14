package com.mercadodabola.mercadotransferencia.domain.converters.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.mercadodabola.mercadotransferencia.domain.converters.ClubeConverter;
import com.mercadodabola.mercadotransferencia.domain.dtos.ClubeDto;
import com.mercadodabola.mercadotransferencia.domain.dtos.GolAssistenciaDto;
import com.mercadodabola.mercadotransferencia.domain.entities.GolAssistPartidaEntity;
import com.mercadodabola.mercadotransferencia.domain.entities.JogadorEntity;
import com.mercadodabola.mercadotransferencia.domain.enums.TipoGolAssist;
import com.mercadodabola.mercadotransferencia.repositories.GolAssistPartidaRepository;

@Component
public class ClubeConverterImpl implements ClubeConverter {
	
	@Autowired
	private GolAssistPartidaRepository golAssistPartidaRepository;
	
	public ClubeDto listaGolAssistencia(JogadorEntity jogadorEntity) {
		ClubeDto retorno = ClubeDto.builder()
				.nome(jogadorEntity.getNome())
				.build();
		
		return retorno;
	}
	
	
}
