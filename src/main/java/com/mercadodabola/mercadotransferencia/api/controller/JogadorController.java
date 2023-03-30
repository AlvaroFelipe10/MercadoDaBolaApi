package com.mercadodabola.mercadotransferencia.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mercadodabola.mercadotransferencia.domain.dtos.JogadorDto;
import com.mercadodabola.mercadotransferencia.domain.entities.ClubeEntity;
import com.mercadodabola.mercadotransferencia.domain.entities.JogadorEntity;
import com.mercadodabola.mercadotransferencia.services.JogadorService;


@RestController
@RequestMapping(value = "/jogadores")
public class JogadorController {
	
	
	@Autowired
	private JogadorService jogadorService;
	
	@GetMapping
	public List<JogadorDto> listar(){
		return jogadorService.listar();
	}
	
	@GetMapping("/{jogadorId}")
	public ResponseEntity<JogadorDto> buscar(@PathVariable Long jogadorId){
		return jogadorService.buscar(jogadorId);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public JogadorEntity cadastrar(@RequestBody @Valid JogadorEntity jogador) {
		return jogadorService.salvar(jogador);
	}
	
}
