package com.mercadodabola.mercadotransferencia.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mercadodabola.mercadotransferencia.domain.entities.ClubeEntity;
import com.mercadodabola.mercadotransferencia.domain.entities.JogadorEntity;
import com.mercadodabola.mercadotransferencia.repositories.ClubeRepository;

@Service
public class ClubeService {

	@Autowired
	private ClubeRepository clubesRepository;
	
	public List<ClubeEntity> listar(){
		return clubesRepository.findAll();
	}
	
	public ClubeEntity salvar(ClubeEntity clube) {
		return clubesRepository.save(clube);
	}
	
	public ResponseEntity<ClubeEntity> buscar(Long clubeId){
		Optional<ClubeEntity> clube = clubesRepository.findById(clubeId);
		
		if(clube != null) {
			return ResponseEntity.ok(clube.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
}
