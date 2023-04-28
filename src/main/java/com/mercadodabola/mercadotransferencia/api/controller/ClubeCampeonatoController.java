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

import com.mercadodabola.mercadotransferencia.domain.entities.ClubeCampeonatoEntity;
import com.mercadodabola.mercadotransferencia.domain.entities.ClubeCampeonatoId;
import com.mercadodabola.mercadotransferencia.services.ClubeCampeonatoService;

@RestController
@RequestMapping("/clubeCampeonato")
public class ClubeCampeonatoController {
	
	@Autowired
	private ClubeCampeonatoService clubeCampeonatoService;
	
	@GetMapping
	public List<ClubeCampeonatoEntity> listar(){
		return clubeCampeonatoService.listar();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ClubeCampeonatoEntity cadastrar(@RequestBody @Valid ClubeCampeonatoEntity clubeCampeonato, ClubeCampeonatoId clubeCampeonatoId) {
		return clubeCampeonatoService.salvar(clubeCampeonato);
	}
}
