package com.mercadodabola.mercadotransferencia.domain.converters.impl;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.mercadodabola.mercadotransferencia.domain.converters.ClubeConverter;
import com.mercadodabola.mercadotransferencia.domain.dtos.ClubeDto;
import com.mercadodabola.mercadotransferencia.domain.dtos.GolAssistenciaDto;
import com.mercadodabola.mercadotransferencia.domain.entities.GolAssistPartidaEntity;
import com.mercadodabola.mercadotransferencia.domain.entities.JogadorEntity;
import com.mercadodabola.mercadotransferencia.domain.enums.TipoGolAssist;

@Component
public class ClubeConverterImpl implements ClubeConverter {
	

	public ClubeDto listaGolAssistencia(JogadorEntity jogadorEntity) {
		ClubeDto retorno = ClubeDto.builder()
				.nome(jogadorEntity.getNome())
				.build();
		
		retorno.setGols(qtdGols(jogadorEntity.getGolAssistencia()));
		retorno.setAssistencias(qtdAssist(jogadorEntity.getGolAssistencia()));
		return retorno;
	}
	
	private Long qtdGols(List<GolAssistPartidaEntity> list) {
		return CollectionUtils.isEmpty(list) ? 0L
				: list.stream().filter(gol -> gol.getTipoLance() == TipoGolAssist.GOL).count();
	}
	
	private Long qtdAssist(List<GolAssistPartidaEntity> list) {
		return CollectionUtils.isEmpty(list) ? 0L
				: list.stream().filter(assist -> assist.getTipoLance() == TipoGolAssist.ASSISTENCIA).count();
	}

	
}
