package com.mercadodabola.mercadotransferencia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercadodabola.mercadotransferencia.domain.entities.ClubeEntity;
import com.mercadodabola.mercadotransferencia.domain.entities.EstadioEntity;
import com.mercadodabola.mercadotransferencia.domain.exception.ClubeNaoEncontradoException;
import com.mercadodabola.mercadotransferencia.repositories.ClubeRepository;
import com.mercadodabola.mercadotransferencia.repositories.EstadioRepository;

@Service
public class EstadioService {
	
	@Autowired
	private EstadioRepository estadioRepository;
	
	@Autowired
	private ClubeRepository clubeRepository;
	
	public List<EstadioEntity> listar(){
		return estadioRepository.findAll();
	}
	
	public EstadioEntity salvar(EstadioEntity estadio) {
		Long clubeId = estadio.getClube().getId();
		ClubeEntity clube = clubeRepository.findById(clubeId)
				.orElseThrow(() -> new ClubeNaoEncontradoException(String.format("Não existe um cadastro de clube com o código %d", clubeId)));
		return estadioRepository.save(estadio);
	}

}
