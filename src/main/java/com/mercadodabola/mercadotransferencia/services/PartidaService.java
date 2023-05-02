package com.mercadodabola.mercadotransferencia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercadodabola.mercadotransferencia.domain.entities.PartidaEntity;
import com.mercadodabola.mercadotransferencia.repositories.ClubeRepository;
import com.mercadodabola.mercadotransferencia.repositories.PartidaRepository;

@Service
public class PartidaService {

	@Autowired 
	private PartidaRepository partidaRepository;
	
	@Autowired 
	private ClubeRepository clubeRepository;
	
	
	public List<PartidaEntity> listar(){
		return partidaRepository.findAll();
	}
	
	public PartidaEntity salvar(PartidaEntity partidaEntity) {
		
		return partidaRepository.save(partidaEntity);		
	}
	
	
}
