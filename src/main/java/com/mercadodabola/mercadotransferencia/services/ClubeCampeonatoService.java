package com.mercadodabola.mercadotransferencia.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercadodabola.mercadotransferencia.domain.dtos.PartidaDto;
import com.mercadodabola.mercadotransferencia.domain.entities.CampeonatoEntity;
import com.mercadodabola.mercadotransferencia.domain.entities.ClubeCampeonatoEntity;
import com.mercadodabola.mercadotransferencia.domain.exception.NegocioException;
import com.mercadodabola.mercadotransferencia.repositories.CampeonatoRepository;
import com.mercadodabola.mercadotransferencia.repositories.ClubeCampeonatoRepository;
import com.mercadodabola.mercadotransferencia.repositories.ClubeRepository;

@Service
public class ClubeCampeonatoService {
	
	@Autowired
	private ClubeCampeonatoRepository clubeCampeonatoRepository;
	
	@Autowired 
	private ClubeRepository clubeRepository;
	
	@Autowired 
	private CampeonatoRepository campeonatoRepository;
	
	
	public List<ClubeCampeonatoEntity> listar(){
		return clubeCampeonatoRepository.findAll();
	}
	
	public ClubeCampeonatoEntity salvar(ClubeCampeonatoEntity clubeCampeonato) {
		return clubeCampeonatoRepository.save(clubeCampeonato);
	}
	

	
}
