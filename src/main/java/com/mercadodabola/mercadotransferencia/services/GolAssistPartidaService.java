package com.mercadodabola.mercadotransferencia.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercadodabola.mercadotransferencia.domain.dtos.GolAssistenciaDto;
import com.mercadodabola.mercadotransferencia.domain.entities.ClubeEntity;
import com.mercadodabola.mercadotransferencia.domain.entities.GolAssistPartidaEntity;
import com.mercadodabola.mercadotransferencia.domain.entities.JogadorEntity;
import com.mercadodabola.mercadotransferencia.repositories.GolAssistPartidaRepository;
import com.mercadodabola.mercadotransferencia.repositories.JogadorRepository;

@Service
public class GolAssistPartidaService {
	
	@Autowired
	private GolAssistPartidaRepository golAssistRepository;
	
	@Autowired 
	private JogadorRepository jogadorRepository;
	
	public GolAssistPartidaEntity salvar(GolAssistPartidaEntity golAssist) {
		return golAssistRepository.save(golAssist);
	}

	public GolAssistPartidaEntity cadastrar(GolAssistenciaDto golAssistenciaDto) {
		GolAssistPartidaEntity golAssistPartidaEntity = new GolAssistPartidaEntity();
		JogadorEntity jogadorEntity = jogadorRepository.findById(golAssistenciaDto.getIdJogador()).get();
		golAssistPartidaEntity.setMinutoSegundos(golAssistenciaDto.getMinutoSegundo());
		golAssistPartidaEntity.setTipoLance(golAssistenciaDto.getTipoLance());
		
		return golAssistRepository.save(golAssistPartidaEntity);
		
	}
	

		
}
