package com.mercadodabola.mercadotransferencia.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercadodabola.mercadotransferencia.domain.dtos.TransferenciaJogadorDto;
import com.mercadodabola.mercadotransferencia.services.ContratoService;

@RestController
@RequestMapping(value = "/transferencia")
public class TransferenciaController {
	
	@Autowired 
	private ContratoService contratoService;
	
	
	@PutMapping
	public void transferencia(@Valid @RequestBody TransferenciaJogadorDto transfJogador){
		contratoService.transferir(transfJogador);
	}

}
