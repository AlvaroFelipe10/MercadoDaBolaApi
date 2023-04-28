package com.mercadodabola.mercadotransferencia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercadodabola.mercadotransferencia.domain.entities.CampeonatoEntity;
import com.mercadodabola.mercadotransferencia.domain.exception.CampeonatoNaoEncontradoException;
import com.mercadodabola.mercadotransferencia.repositories.CampeonatoRepository;

@Service
public class CampeonatoService {
	
	@Autowired 
	private CampeonatoRepository campeonatoRepository;
	
	public List<CampeonatoEntity> listar(){
		return campeonatoRepository.findAll();
	}
	
	public CampeonatoEntity salvar(CampeonatoEntity campeonato) {
		return campeonatoRepository.save(campeonato);
	}

	public CampeonatoEntity buscarCampeonato(Long campeonatoId) {
		return campeonatoRepository.findById(campeonatoId)
				.orElseThrow(() -> new CampeonatoNaoEncontradoException(String.format("Não existe um cadastro de campeonato com o id %d", campeonatoId)));
	}
}
