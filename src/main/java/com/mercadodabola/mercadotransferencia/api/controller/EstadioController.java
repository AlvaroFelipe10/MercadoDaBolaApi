package com.mercadodabola.mercadotransferencia.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mercadodabola.mercadotransferencia.domain.entities.EstadioEntity;
import com.mercadodabola.mercadotransferencia.services.EstadioService;

@RestController
@RequestMapping("/estadio")
public class EstadioController {
	
	@Autowired 
	private EstadioService estadioService;
	
	@GetMapping
	public List<EstadioEntity> listar(){
		return estadioService.listar();
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public EstadioEntity cadastrar (@RequestBody @Valid EstadioEntity estadio) {
		return estadioService.salvar(estadio);
	}
	

}
