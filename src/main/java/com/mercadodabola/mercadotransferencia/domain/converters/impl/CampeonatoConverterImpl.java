package com.mercadodabola.mercadotransferencia.domain.converters.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mercadodabola.mercadotransferencia.domain.converters.CampeonatoConverter;
import com.mercadodabola.mercadotransferencia.domain.dtos.CampeonatoTabelaDto;
import com.mercadodabola.mercadotransferencia.domain.entities.CampeonatoEntity;
import com.mercadodabola.mercadotransferencia.domain.entities.ClubeEntity;
import com.mercadodabola.mercadotransferencia.repositories.ClubeCampeonatoRepository;
import com.mercadodabola.mercadotransferencia.repositories.GolAssistPartidaRepository;
import com.mercadodabola.mercadotransferencia.repositories.PartidaRepository;

@Component
public class CampeonatoConverterImpl implements CampeonatoConverter {


	@Autowired 
	private ClubeCampeonatoRepository clubeCampeonatoRepository;
	
	@Autowired
	private GolAssistPartidaRepository golAssistPartidaRepository;
	
	@Autowired
	private PartidaRepository partidaRepository;

	@Override
	public CampeonatoTabelaDto tabelaCampeonato(ClubeEntity clubeEntity, CampeonatoEntity campeonatoEntity) {
		CampeonatoTabelaDto dto = CampeonatoTabelaDto.builder()
				.nome(clubeEntity.getNome())
				//.golsFeitos(partidaEntity.getGolsMandante())
				//.golsSofridos(partidaEntity.getGolsVisitante())
				.build();
		dto.setVitorias(clubeCampeonatoRepository.qtdVitorias(clubeEntity.getId()));
		dto.setPontos(clubeCampeonatoRepository.qtdPontos(clubeEntity.getId()));
		dto.setDerrotas(clubeCampeonatoRepository.qtdDerrotas(clubeEntity.getId()));
		dto.setEmpates(clubeCampeonatoRepository.qtdEmpates(clubeEntity.getId()));
		dto.setGolsFeitos(partidaRepository.qtdGols(campeonatoEntity.getId(), clubeEntity.getId()));
	
		//dto.setSaldoDeGols(partidaEntity.getGolsMandante() - partidaEntity.getGolsVisitante());
//		if(dto.getGolsFeitos() > dto.getGolsSofridos())
//			dto.setVitorias((long) + 1); dto.setDerrotas((long) 0); dto.setEmpates((long) 0);
//		if(dto.getGolsSofridos() > dto.getGolsFeitos())
//			dto.setDerrotas((long) + 1);
//		if(dto.getGolsFeitos() == dto.getGolsSofridos())
//			dto.setEmpates((long) + 1);
		return dto;
	}
	
	
}


