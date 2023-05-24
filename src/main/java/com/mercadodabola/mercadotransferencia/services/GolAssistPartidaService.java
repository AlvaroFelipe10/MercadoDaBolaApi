package com.mercadodabola.mercadotransferencia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercadodabola.mercadotransferencia.domain.dtos.GolAssistenciaDto;
import com.mercadodabola.mercadotransferencia.domain.entities.GolAssistPartidaEntity;
import com.mercadodabola.mercadotransferencia.domain.entities.JogadorEntity;
import com.mercadodabola.mercadotransferencia.repositories.GolAssistPartidaRepository;

@Service
public class GolAssistPartidaService {
	
	@Autowired
	private GolAssistPartidaRepository golAssistRepository;
	
	public GolAssistPartidaEntity salvar(GolAssistPartidaEntity golAssist) {
		return golAssistRepository.save(golAssist);
	}

	public GolAssistPartidaEntity cadastrar(GolAssistenciaDto golAssistenciaDto) {
		GolAssistPartidaEntity golAssistPartidaEntity = new GolAssistPartidaEntity();
		golAssistPartidaEntity.setGolAssistPartidaId(golAssistenciaDto.getGolAssistPartidaId());
		golAssistPartidaEntity.setIdJogador(golAssistenciaDto.getIdJogador());
		golAssistPartidaEntity.setMinutoSegundos(golAssistenciaDto.getMinutoSegundo());
		golAssistPartidaEntity.setTipoLance(golAssistenciaDto.getTipoLance());
		return golAssistRepository.save(golAssistPartidaEntity);
		
	}
	

		
}
