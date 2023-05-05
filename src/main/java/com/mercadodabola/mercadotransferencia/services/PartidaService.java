package com.mercadodabola.mercadotransferencia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.mercadodabola.mercadotransferencia.domain.dtos.GolAssistenciaDto;
import com.mercadodabola.mercadotransferencia.domain.dtos.PartidaDto;
import com.mercadodabola.mercadotransferencia.domain.entities.CampeonatoEntity;
import com.mercadodabola.mercadotransferencia.domain.entities.ClubeEntity;
import com.mercadodabola.mercadotransferencia.domain.entities.PartidaEntity;
import com.mercadodabola.mercadotransferencia.domain.entities.PartidaId;
import com.mercadodabola.mercadotransferencia.domain.enums.MandanteOuVisitante;
import com.mercadodabola.mercadotransferencia.domain.enums.TipoGolAssist;
import com.mercadodabola.mercadotransferencia.repositories.CampeonatoRepository;
import com.mercadodabola.mercadotransferencia.repositories.ClubeRepository;
import com.mercadodabola.mercadotransferencia.repositories.PartidaRepository;

@Service
public class PartidaService {

	@Autowired 
	private PartidaRepository partidaRepository;
	
	@Autowired 
	private ClubeRepository clubeRepository;
	
	@Autowired
	private CampeonatoRepository campeonatoRepository;
	
	
	public PartidaEntity salvar(PartidaEntity partidaEntity) {
		return partidaRepository.save(partidaEntity);		
	}
	
	public PartidaEntity cadastroPartida(PartidaDto partidaDto) {
		ClubeEntity mandante = clubeRepository.findById(partidaDto.getMandanteId()).get();
		CampeonatoEntity campeonato = campeonatoRepository.findById(partidaDto.getCampeonatoId()).get();
		ClubeEntity visitante = clubeRepository.findById(partidaDto.getVisitanteId()).get();
		
		PartidaId partidaId = new PartidaId();
		partidaId.setVisitante(visitante);
		partidaId.setMandante(mandante);
		partidaId.setCampeonato(campeonato);
		
		PartidaEntity partidaEntity = new PartidaEntity();
		partidaEntity.setId(partidaId);
		partidaEntity.setNumeroRodada(partidaDto.getRodada());
		partidaEntity.setDataHoraPartida(partidaDto.getDataEHora());
		partidaEntity.setPublico(partidaDto.getPublico());
		partidaEntity.setRenda(partidaDto.getRenda());
		partidaEntity.setGolsMandante(qtdGols(partidaDto.getGolAssistencia(), MandanteOuVisitante.MANDANTE));
		partidaEntity.setGolsVisitante(qtdGols(partidaDto.getGolAssistencia(), MandanteOuVisitante.VISITANTE));
		
		return partidaEntity;
		
	}
	
		private Long qtdGols(List<GolAssistenciaDto> golsAssistencia, MandanteOuVisitante mandanteouVisitante) {
			return CollectionUtils.isEmpty(golsAssistencia) ? 0L
					: golsAssistencia
						.stream()
						.filter(gol -> gol.getTipoLance() == TipoGolAssist.GOL 
								&& gol.getMandanteOuVisitante()== mandanteouVisitante)
						.count();
		}
		
		
		
//	private Long qtdGolsVisitanteSemStream(List<GolAssistenciaDto> golsAssistencia) {
//		Long qtdGols = 0L;
//		
//		if(CollectionUtils.isEmpty(golsAssistencia)) {
//			return qtdGols;
//		} else {
//			for (GolAssistenciaDto gol : golsAssistencia) {
//				if(gol.getMandanteOuVisitante() == MandanteOuVisitante.VISITANTE
//						&& gol.getTipoLance() == TipoGolAssist.GOL) {
//					qtdGols++;
//				}
//			}
//		}
//		return qtdGols;
//	}
		
}
