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

import com.mercadodabola.mercadotransferencia.domain.dtos.GolsAssistenciasDto;
import com.mercadodabola.mercadotransferencia.domain.dtos.JogadorListDto;
import com.mercadodabola.mercadotransferencia.domain.entities.GolAssistPartidaEntity;
import com.mercadodabola.mercadotransferencia.services.GolAssistPartidaService;

@RestController
@RequestMapping("/golAssist")
public class GolAssistPartidaController {
	
	@Autowired
	private GolAssistPartidaService golAssistPartidaService;
	
	@GetMapping
	public List<GolsAssistenciasDto> listar(){
		return golAssistPartidaService.listar();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public GolAssistPartidaEntity cadastrar(@RequestBody @Valid GolAssistPartidaEntity golAssist) {
		return golAssistPartidaService.salvar(golAssist);
	}
	

}
