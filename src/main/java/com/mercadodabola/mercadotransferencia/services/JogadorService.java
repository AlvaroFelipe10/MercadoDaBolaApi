package com.mercadodabola.mercadotransferencia.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.mercadodabola.mercadotransferencia.domain.entities.Jogador;
import com.mercadodabola.mercadotransferencia.repositories.JogadorRepository;

@Service
public class JogadorService {
	
	@Autowired
	private JogadorRepository jogadorRepository;

	
	public List<Jogador> listar(){
		return jogadorRepository.findAll();
	}
	
	public Jogador salvar(Jogador jogador) {
		return jogadorRepository.save(jogador);
	}
	
	public ResponseEntity<Jogador> buscar(Long jogadorId){
		Optional<Jogador> jogador = jogadorRepository.findById(jogadorId);
		
		if(jogador != null) {
			return ResponseEntity.ok(jogador.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	
		
	
}
