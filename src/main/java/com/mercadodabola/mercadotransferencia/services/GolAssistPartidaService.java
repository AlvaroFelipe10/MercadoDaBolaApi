package com.mercadodabola.mercadotransferencia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercadodabola.mercadotransferencia.domain.entities.GolAssistPartidaEntity;
import com.mercadodabola.mercadotransferencia.repositories.GolAssistPartidaRepository;

@Service
public class GolAssistPartidaService {
	
	@Autowired
	private GolAssistPartidaRepository golAssistRepository;
	
	public GolAssistPartidaEntity salvar(GolAssistPartidaEntity golAssist) {
		return golAssistRepository.save(golAssist);
	}
}
