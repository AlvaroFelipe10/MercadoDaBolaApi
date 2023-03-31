package com.mercadodabola.mercadotransferencia.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.mercadodabola.mercadotransferencia.domain.converters.JogadorConverter;
import com.mercadodabola.mercadotransferencia.domain.dtos.JogadorDto;
import com.mercadodabola.mercadotransferencia.domain.entities.JogadorEntity;
import com.mercadodabola.mercadotransferencia.domain.enums.Posicoes;
import com.mercadodabola.mercadotransferencia.repositories.JogadorRepository;

@Service
public class JogadorService {
	
	@Autowired
	private JogadorRepository jogadorRepository;
	
	@Autowired
	private JogadorConverter jogadorConverter;
	
	
	public JogadorEntity salvar(JogadorEntity jogador) {	
		return jogadorRepository.save(jogador);
	}
	
	
	public List<JogadorDto> listar(){ 
		List<JogadorDto> retorno = new ArrayList<>();
		List<JogadorEntity> listEntity =  jogadorRepository.findAll();
		listEntity.forEach(jogadorEntity -> {
			JogadorDto dto = jogadorConverter.toJogadorDto(jogadorEntity);
			retorno.add(dto);
		});
			return retorno;	
		}
	
	public ResponseEntity<JogadorDto> buscar(Long jogadorId){
		Optional<JogadorEntity> jogador = jogadorRepository.findById(jogadorId);
		if(jogador != null) {
			return ResponseEntity.ok(jogadorConverter.toJogadorDto(jogador.get()));
		}
		return ResponseEntity.notFound().build();
	}	
	
	
	
	public JogadorEntity adicionar(JogadorEntity jogadorEntity) {
		return jogadorRepository.save(jogadorEntity);
	}
}


	