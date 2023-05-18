package com.mercadodabola.mercadotransferencia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercadodabola.mercadotransferencia.domain.entities.GolAssistPartidaEntity;
import com.mercadodabola.mercadotransferencia.domain.entities.JogadorEntity;
import com.mercadodabola.mercadotransferencia.domain.entities.PartidaEntity;
import com.mercadodabola.mercadotransferencia.domain.entities.PartidaId;
import com.mercadodabola.mercadotransferencia.repositories.GolAssistPartidaRepository;

@Service
public class GolAssistPartidaService {
	
	@Autowired
	private GolAssistPartidaRepository golAssistRepository;
	
	
	public GolAssistPartidaEntity cadastrarGolAssist(PartidaEntity partida, JogadorEntity jogador) {
		GolAssistPartidaEntity golAssist = new GolAssistPartidaEntity();
		
		PartidaId partidaId = new PartidaId();
		return null;
	}

}
