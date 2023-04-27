package com.mercadodabola.mercadotransferencia.api.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mercadodabola.mercadotransferencia.domain.dtos.JogadorListDto;
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
	
	@GetMapping("/por-salario-maior")
	public List<JogadorListDto> listarPorOrdemSalarioMaisAlto(){
		return contratoService.listarPorOrdemSalarioMaisAlto();
	}
	
	@GetMapping("/por-salario-menor")
	public List<JogadorListDto> listarPorOrdemSalarioMaisBaixo(){
		return contratoService.listarPorOrdemSalarioMaisBaixo();
	}
	
	@GetMapping("listar-todos")
	public List<JogadorListDto> listarPorOrdemSalario(String order){
		return contratoService.listarPorOrdemSalario(order);
	}
	
	@DeleteMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable long contratoId) {
		contratoRepository.deleteById(contratoId);;
	}
}
