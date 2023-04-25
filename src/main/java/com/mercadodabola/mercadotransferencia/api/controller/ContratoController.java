package com.mercadodabola.mercadotransferencia.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mercadodabola.mercadotransferencia.domain.entities.ContratoEntity;
import com.mercadodabola.mercadotransferencia.repositories.ContratoRepository;
import com.mercadodabola.mercadotransferencia.services.ContratoService;

@RestController
@RequestMapping("/contrato")
public class ContratoController {
	
	@Autowired
	private ContratoRepository contratoRepository;
	
	@Autowired
	private ContratoService contratoService;
	
	@GetMapping("/por-salario")
	public List<ContratoEntity> listar(){
		return contratoService.listar();
	}

	@DeleteMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable long contratoId) {
		contratoRepository.deleteById(contratoId);;
	}
}
