package com.mercadodabola.mercadotransferencia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercadodabola.mercadotransferencia.domain.dtos.GolAssistenciaDto;
import com.mercadodabola.mercadotransferencia.domain.dtos.PartidaDto;
import com.mercadodabola.mercadotransferencia.domain.entities.GolAssistPartidaEntity;
import com.mercadodabola.mercadotransferencia.domain.entities.GolAssistPartidaEntityId;
import com.mercadodabola.mercadotransferencia.domain.entities.JogadorEntity;
import com.mercadodabola.mercadotransferencia.domain.entities.PartidaEntity;
import com.mercadodabola.mercadotransferencia.repositories.GolAssistPartidaRepository;
import com.mercadodabola.mercadotransferencia.repositories.JogadorRepository;
import com.mercadodabola.mercadotransferencia.repositories.PartidaRepository;

@Service
public class GolAssistPartidaService {
	
	@Autowired
	private GolAssistPartidaRepository golAssistRepository;
	
	@Autowired 
	private JogadorRepository jogadorRepository;
	
	@Autowired
	private PartidaRepository partidaRepository;
	
	public GolAssistPartidaEntity salvar(GolAssistPartidaEntity golAssist) {
		return golAssistRepository.save(golAssist);
	}

	public GolAssistPartidaEntity cadastrar(GolAssistenciaDto golAssistenciaDto, PartidaDto partidaDto) {
		GolAssistPartidaEntity golAssistPartidaEntity = new GolAssistPartidaEntity();
		GolAssistPartidaEntityId golAssistPartidaEntityId = new GolAssistPartidaEntityId();
		PartidaEntity partidaEntity = partidaRepository.findById(partidaDto.getPartidaId()).get();
		JogadorEntity jogadorEntity = jogadorRepository.findById(golAssistenciaDto.getIdJogador()).get();
		golAssistPartidaEntity.setMinutoSegundos(golAssistenciaDto.getMinutoSegundo());
		golAssistPartidaEntity.setTipoLance(golAssistenciaDto.getTipoLance());
		
		golAssistPartidaEntityId.setIdJogador(jogadorEntity);
		golAssistPartidaEntityId.setPartida(partidaEntity);
		
		return golAssistRepository.save(golAssistPartidaEntity);
		
	}
	

		
}
