package com.mercadodabola.mercadotransferencia.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mercadodabola.mercadotransferencia.domain.entities.ClubeEntity;
import com.mercadodabola.mercadotransferencia.repositories.ClubeRepository;
import com.mercadodabola.mercadotransferencia.repositories.ContratoRepository;

@Service
public class ClubeService {

	@Autowired
	private ClubeRepository clubeRepository;
	
	@Autowired 
	private ContratoRepository contratoRepository;
	
	
	public List<ClubeEntity> listar(){
		return clubeRepository.findAll();
	}
	
	public ClubeEntity salvar(ClubeEntity clube) {
		return clubeRepository.save(clube);
	}
	
	public ResponseEntity<ClubeEntity> buscar(Long clubeId){
		Optional<ClubeEntity> clube = clubeRepository.findById(clubeId);
	
		if(clube != null) {
			return ResponseEntity.ok(clube.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	
	
}
