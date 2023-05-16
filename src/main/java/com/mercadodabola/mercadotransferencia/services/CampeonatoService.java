package com.mercadodabola.mercadotransferencia.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercadodabola.mercadotransferencia.domain.dtos.CampeonatoDto;
import com.mercadodabola.mercadotransferencia.domain.dtos.ListaJogadorPorClubeIdDto;
import com.mercadodabola.mercadotransferencia.domain.entities.CampeonatoEntity;
import com.mercadodabola.mercadotransferencia.domain.entities.ClubeCampeonatoEntity;
import com.mercadodabola.mercadotransferencia.domain.entities.ClubeEntity;
import com.mercadodabola.mercadotransferencia.domain.exception.CampeonatoNaoEncontradoException;
import com.mercadodabola.mercadotransferencia.repositories.CampeonatoRepository;
import com.mercadodabola.mercadotransferencia.repositories.ClubeRepository;

@Service
public class CampeonatoService {
	
	@Autowired 
	private CampeonatoRepository campeonatoRepository;
	
	@Autowired 
	private ClubeRepository clubeRepository;
	
	@Autowired 
	private ClubeCampeonatoService clubeCampeonato;
	
	CampeonatoEntity campeonatoEntity;
	
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
	
	public CampeonatoEntity cadastrarCampeonato(CampeonatoDto campeonatoDto) {
		campeonatoEntity = new CampeonatoEntity();
		campeonatoEntity.setNomeCampeonato(campeonatoDto.getNomeDoCampeonato());
		campeonatoEntity.setQuantidadeClubes(campeonatoDto.getClubesCadastrados().size());
		campeonatoEntity.setTipoDeCampeonato(campeonatoDto.getTipoDeCampeonato());	 
		
		campeonatoEntity = campeonatoRepository.save(campeonatoEntity);
		
		campeonatoDto.getClubesCadastrados().forEach(clube -> {
						ClubeCampeonatoEntity dto = clubeCampeonato.cadastrarClubeCampeonato(campeonatoEntity, clube);
						
	
			//chamarmeumetodoPassandoEssesParametros(clube.getId(), campeonatoEntity.getCampeonatoId());
		});
		
		return campeonatoEntity;
		
	}
	
	
	
}
