package com.mercadodabola.mercadotransferencia.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.mercadodabola.mercadotransferencia.domain.converters.JogadorConverter;
import com.mercadodabola.mercadotransferencia.domain.dtos.JogadorDto;
import com.mercadodabola.mercadotransferencia.domain.entities.JogadorEntity;
import com.mercadodabola.mercadotransferencia.repositories.JogadorRepository;

@Service
public class JogadorService {
	
	@Autowired
	private JogadorRepository jogadorRepository;
	
	@Autowired
	private JogadorConverter jogadorConverter;

	
	
	public List<JogadorDto> listar(){ 
		List<JogadorDto> retorno = new ArrayList<>();
		List<JogadorEntity> listEntity =  jogadorRepository.findAll();
		
		listEntity.forEach(jogadorEntity -> {
			JogadorDto dto = jogadorConverter.toJogadorDto(jogadorEntity);
			retorno.add(dto);
		});
		
			return retorno;	
		}
	
	
	public JogadorEntity salvar(JogadorEntity jogador) {
		return jogadorRepository.save(jogador);
	}
	
	public ResponseEntity<JogadorEntity> buscar(Long jogadorId){
		Optional<JogadorEntity> jogador = jogadorRepository.findById(jogadorId);
		
		if(jogador != null) {
			return ResponseEntity.ok(jogador.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	
		
	
}
