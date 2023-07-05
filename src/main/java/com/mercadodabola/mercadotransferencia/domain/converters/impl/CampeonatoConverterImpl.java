package com.mercadodabola.mercadotransferencia.domain.converters.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mercadodabola.mercadotransferencia.domain.converters.CampeonatoConverter;
import com.mercadodabola.mercadotransferencia.domain.dtos.CampeonatoTabelaDto;
import com.mercadodabola.mercadotransferencia.domain.entities.CampeonatoEntity;
import com.mercadodabola.mercadotransferencia.domain.entities.ClubeEntity;
import com.mercadodabola.mercadotransferencia.domain.entities.PartidaEntity;
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
	public CampeonatoTabelaDto tabelaCampeonato(ClubeEntity clubeEntity, CampeonatoEntity campeonatoEntity, PartidaEntity partidaEntity) {
		CampeonatoTabelaDto dto = CampeonatoTabelaDto.builder()
				.nome(clubeEntity.getNome())
				.build();
		dto.setVitorias(clubeCampeonatoRepository.qtdVitorias(clubeEntity.getId()));
		dto.setPontos(clubeCampeonatoRepository.qtdPontos(clubeEntity.getId()));
		dto.setDerrotas(clubeCampeonatoRepository.qtdDerrotas(clubeEntity.getId()));
		dto.setEmpates(clubeCampeonatoRepository.qtdEmpates(clubeEntity.getId()));
		dto.setGolsFeitos(golAssistPartidaRepository.qtdGolsClubesTab(campeonatoEntity.getId(), clubeEntity.getId()));
		dto.setGolsSofridos(golAssistPartidaRepository.qtdGolsTomadosTab(campeonatoEntity.getId(), clubeEntity.getId(), partidaEntity.getId()));
		dto.setSaldoDeGols(dto.getGolsFeitos() - dto.getGolsSofridos());
		return dto;
	}
	
	
}


