package com.mercadodabola.mercadotransferencia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercadodabola.mercadotransferencia.domain.dtos.GolAssistenciaDto;
import com.mercadodabola.mercadotransferencia.domain.dtos.PartidaDto;
import com.mercadodabola.mercadotransferencia.domain.entities.GolAssistPartidaEntity;
import com.mercadodabola.mercadotransferencia.domain.entities.JogadorEntity;
import com.mercadodabola.mercadotransferencia.domain.entities.PartidaEntity;
import com.mercadodabola.mercadotransferencia.repositories.GolAssistPartidaRepository;

@Service
public class GolAssistPartidaService {
	
	@Autowired
	private GolAssistPartidaRepository golAssistRepository;
	
	
	public void cadastrarGolAssist(PartidaDto partidaDto, GolAssistenciaDto golAssistDto) {
		GolAssistPartidaEntity golAssist = new GolAssistPartidaEntity();
		golAssist.setJogadorId(golAssistDto.getIdJogador());
		golAssist.setMinutoSegundos(golAssist.getMinutoSegundos());
		golAssist.setGolAssist(golAssistDto.getTipoLance());
		golAssistRepository.save(golAssist);
	}
	

}
