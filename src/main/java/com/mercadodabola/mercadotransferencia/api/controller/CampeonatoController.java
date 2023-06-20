package com.mercadodabola.mercadotransferencia.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mercadodabola.mercadotransferencia.domain.dtos.CampeonatoDto;
import com.mercadodabola.mercadotransferencia.domain.dtos.CampeonatoTabelaDto;
import com.mercadodabola.mercadotransferencia.domain.entities.CampeonatoEntity;
import com.mercadodabola.mercadotransferencia.services.CampeonatoService;

@RestController
@RequestMapping("/campeonato")
public class CampeonatoController {
	
	@Autowired
	private CampeonatoService campeonatoService;
	
	
	@GetMapping
	public List<CampeonatoEntity> listar(){
		return campeonatoService.listar();
	}
	
	@GetMapping("/{campeonatoId}") 
	public List<CampeonatoTabelaDto> buscarCampeonatoEntity(@PathVariable Long campeonatoId) {
		return campeonatoService.listaTabela(campeonatoId);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CampeonatoEntity cadastrar(@RequestBody @Valid CampeonatoDto campeonatoDto) {
		return campeonatoService.cadastrarCampeonato(campeonatoDto);
	}

}
