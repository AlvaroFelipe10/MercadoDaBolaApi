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

import com.mercadodabola.mercadotransferencia.domain.entities.PartidaEntity;
import com.mercadodabola.mercadotransferencia.domain.entities.PartidaId;
import com.mercadodabola.mercadotransferencia.services.PartidaService;

@RestController
@RequestMapping(value = "/partida")
public class PartidaController {

	@Autowired
	private PartidaService partidaService;
	
	@GetMapping
	public List<PartidaEntity> listar(){
		return partidaService.listar();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PartidaEntity cadastroDePartida(@RequestBody @Valid PartidaEntity partidaEntity) {
		return partidaService.salvar(partidaEntity);
	}
}
