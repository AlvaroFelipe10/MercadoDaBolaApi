package com.mercadodabola.mercadotransferencia.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mercadodabola.mercadotransferencia.domain.converters.JogadorConverter;
import com.mercadodabola.mercadotransferencia.domain.dtos.AtualizacaoDeCaixaDto;
import com.mercadodabola.mercadotransferencia.domain.dtos.ClubeDto;
import com.mercadodabola.mercadotransferencia.domain.entities.ClubeEntity;
import com.mercadodabola.mercadotransferencia.repositories.ClubeRepository;
import com.mercadodabola.mercadotransferencia.repositories.ContratoRepository;
import com.mercadodabola.mercadotransferencia.repositories.GolAssistPartidaRepository;
import com.mercadodabola.mercadotransferencia.repositories.JogadorRepository;

@Service
public class ClubeService {

	@Autowired
	private ClubeRepository clubeRepository;
	
	@Autowired 
	private ContratoRepository contratoRepository;
	
	@Autowired
	private JogadorConverter jogadorConverter;
	
	@Autowired 
	private GolAssistPartidaRepository golAssistRepository;
	
	
	@Autowired 
	private JogadorRepository jogadorRepository;
	

	public List<ClubeEntity> listar(){
		return clubeRepository.findAll();
	}
	
	public ClubeEntity salvar(ClubeEntity clube) {
		return clubeRepository.save(clube);
	}
	
	public ClubeEntity atualizarCaixa(AtualizacaoDeCaixaDto atualizarCaixa) {
		ClubeEntity clubeEntity = clubeRepository.findById(atualizarCaixa.getClubeId()).get();
		clubeEntity.setCaixa(clubeEntity.getCaixa().add(atualizarCaixa.getFaturamentoBilheteria()));
		clubeEntity.setCaixa(clubeEntity.getCaixa().add(atualizarCaixa.getFaturamentoPatrocinio()));
		contratoRepository.obterSalarioTotal(clubeEntity.getId());
		clubeEntity.setCaixa(clubeEntity.getCaixa().subtract(contratoRepository.obterSalarioTotal(clubeEntity.getId())));
		
		
			return clubeRepository.save(clubeEntity);
	}
	
	public ResponseEntity<ClubeEntity> buscar(Long clubeId){
		Optional<ClubeEntity> clube = clubeRepository.findById(clubeId);
		if(clube != null) {
			return ResponseEntity.ok(clube.get()); 
		}
		return ResponseEntity.notFound().build();
	}
	
	
	}
	
	

