package com.mercadodabola.mercadotransferencia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercadodabola.mercadotransferencia.domain.entities.CampeonatoEntity;
import com.mercadodabola.mercadotransferencia.domain.entities.ClubeCampeonatoEntity;
import com.mercadodabola.mercadotransferencia.repositories.ClubeCampeonatoRepository;
import com.mercadodabola.mercadotransferencia.repositories.ClubeRepository;

@Service
public class ClubeCampeonatoService {
	
	@Autowired
	private ClubeCampeonatoRepository clubeCampeonatoRepository;
	
	@Autowired 
	private ClubeRepository clubeRepository;

	
	public List<ClubeCampeonatoEntity> listar(){
		return clubeCampeonatoRepository.findAll();
	}
	
	public ClubeCampeonatoEntity salvar(ClubeCampeonatoEntity clubeCampeonato) {
		return clubeCampeonatoRepository.save(clubeCampeonato);
	}
	
	
}
