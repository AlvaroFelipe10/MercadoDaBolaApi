package com.mercadodabola.mercadotransferencia.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mercadodabola.mercadotransferencia.domain.dtos.AtualizacaoDeCaixaDto;
import com.mercadodabola.mercadotransferencia.domain.dtos.ClubeDto;
import com.mercadodabola.mercadotransferencia.domain.dtos.ListaJogadorPorClubeIdDto;
import com.mercadodabola.mercadotransferencia.domain.entities.ClubeEntity;
import com.mercadodabola.mercadotransferencia.services.ClubeService;
import com.mercadodabola.mercadotransferencia.services.JogadorService;

@RestController
@RequestMapping("/clubes")
public class ClubeController {
	
	@Autowired
	private ClubeService clubeService;
	
	@Autowired
	private JogadorService jogadorService;
	
	@GetMapping
	public List<ClubeEntity> listar(){
		return clubeService.listar();
	}
	
//	@GetMapping("/{clubeId}")
//	public List<ListaJogadorPorClubeIdDto> listaJogador(@PathVariable  Long clubeId){
//		return jogadorService.listaJogadorPorIdClube(clubeId);
//	}
	
//	@GetMapping("/{clubeId}")
//	public List<ClubeDto> listaGolAssistencia(@PathVariable Long clubeId){
//		return jogadorService.listaGolAssistencia(clubeId);
//	}
	
	@PutMapping("/atualizacaoCaixa")
	public ClubeEntity atualizacaoCaixa(@Valid @RequestBody AtualizacaoDeCaixaDto atualizaCaixa) {
		return clubeService.atualizarCaixa(atualizaCaixa);
	}
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void cadastrar(@RequestBody @Valid ClubeEntity clube) {
		clubeService.salvar(clube);
	}
	
	
	
}
