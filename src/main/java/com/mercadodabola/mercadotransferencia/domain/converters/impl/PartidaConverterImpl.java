package com.mercadodabola.mercadotransferencia.domain.converters.impl;

import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import com.mercadodabola.mercadotransferencia.domain.converters.PartidaConverter;
import com.mercadodabola.mercadotransferencia.domain.dtos.PartidaDto;
import com.mercadodabola.mercadotransferencia.domain.entities.PartidaEntity;

@Component
public class PartidaConverterImpl  implements PartidaConverter {

	public PartidaDto listPartida(PartidaEntity partidaEntity) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		PartidaDto retorno = PartidaDto.builder()
				.rodada(partidaEntity.getNumeroRodada())
				.golsMandante(partidaEntity.getGolsMandante())
				.golsVisitante(partidaEntity.getGolsVisitante())
				.mandante(partidaEntity.getId().getMandanteId().getNome())
				.visitante(partidaEntity.getId().getVisitanteId().getNome())
				.dataEHora(partidaEntity.getDataHoraPartida().format(formatter))
				.publico(partidaEntity.getPublico())
				.renda(partidaEntity.getRenda())
				.build();
		return retorno;
	}

	
}
