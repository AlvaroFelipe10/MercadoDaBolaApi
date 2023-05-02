package com.mercadodabola.mercadotransferencia.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercadodabola.mercadotransferencia.domain.converters.PartidaConverter;
import com.mercadodabola.mercadotransferencia.domain.dtos.PartidaDto;
import com.mercadodabola.mercadotransferencia.domain.entities.PartidaEntity;
import com.mercadodabola.mercadotransferencia.repositories.ClubeRepository;
import com.mercadodabola.mercadotransferencia.repositories.PartidaRepository;

@Service
public class PartidaService {

	@Autowired 
	private PartidaRepository partidaRepository;
	
	@Autowired 
	private ClubeRepository clubeRepository;
	
	@Autowired
	private PartidaConverter partidaConverter;
	
	public List<PartidaDto> listar(){
		List<PartidaDto> retorno = new ArrayList<>();
		List<PartidaEntity> listEntity = partidaRepository.findAll();
		listEntity.forEach(partidaEntity -> {
			PartidaDto dto = partidaConverter.listPartida(partidaEntity);
			retorno.add(dto);
		});
		
		return retorno ;
	}
	
	public PartidaEntity salvar(PartidaEntity partidaEntity) {
		
		
		return partidaRepository.save(partidaEntity);		
	}
	
	
}
