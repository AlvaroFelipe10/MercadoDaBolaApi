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
import com.mercadodabola.mercadotransferencia.domain.entities.GolAssistPartidaEntity;
import com.mercadodabola.mercadotransferencia.services.GolAssistPartidaService;

@RestController
@RequestMapping("/golAssist")
public class GolAssistPartidaController {
	
	@Autowired
	private GolAssistPartidaService golAssistPartidaService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public GolAssistPartidaEntity cadastrar(@RequestBody @Valid GolAssistenciaDto golAssistDto, PartidaDto partidaDto) {
		return golAssistPartidaService.cadastrar(golAssistDto, partidaDto);
	}
	

}
