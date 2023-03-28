package com.mercadodabola.mercadotransferencia.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercadodabola.mercadotransferencia.domain.entities.Jogador;
import com.mercadodabola.mercadotransferencia.services.JogadorService;


@RestController
@RequestMapping(value = "/jogadores")
public class JogadorController {
	
	
	@Autowired
	private JogadorService jogadorService;
	
	@GetMapping
	public List<Jogador> listar(){
		return jogadorService.listar();
	}
	
	@GetMapping ("/{jogadorId}")
	public ResponseEntity<Jogador> buscar(@PathVariable Long jogadorId) {
		return jogadorService.buscar(jogadorId);
	}
	
	

}
