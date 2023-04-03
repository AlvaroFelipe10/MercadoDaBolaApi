package com.mercadodabola.mercadotransferencia.api.controller;

import java.util.List;

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

import com.mercadodabola.mercadotransferencia.domain.entities.ClubeEntity;
import com.mercadodabola.mercadotransferencia.domain.entities.JogadorEntity;
import com.mercadodabola.mercadotransferencia.services.ClubeService;

@RestController
@RequestMapping("/clubes")
public class ClubeController {
	
	@Autowired
	private ClubeService clubeService;
	
	@GetMapping
	public List<ClubeEntity> listar(){
		return clubeService.listar();
	}
	
	
	@GetMapping("/{clubeId}")
	public ResponseEntity<ClubeEntity> buscar(@PathVariable Long clubeId){
		return clubeService.buscar(clubeId);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void cadastrar(@RequestBody @Valid ClubeEntity clube) {
		clubeService.salvar(clube);
	}
	

}
