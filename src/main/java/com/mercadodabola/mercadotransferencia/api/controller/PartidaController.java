package com.mercadodabola.mercadotransferencia.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mercadodabola.mercadotransferencia.domain.dtos.GolAssistenciaDto;
import com.mercadodabola.mercadotransferencia.domain.dtos.PartidaDto;
import com.mercadodabola.mercadotransferencia.domain.entities.PartidaEntity;
import com.mercadodabola.mercadotransferencia.services.PartidaService;

@RestController
@RequestMapping(value = "/partida")
public class PartidaController {

	@Autowired
	private PartidaService partidaService;
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PartidaEntity cadastroDePartida(@RequestBody @Valid PartidaDto partidaDto) {
		return partidaService.cadastroPartida(partidaDto);
	}
}
