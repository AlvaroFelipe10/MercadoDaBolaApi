package com.mercadodabola.mercadotransferencia.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercadodabola.mercadotransferencia.domain.converters.CampeonatoConverter;
import com.mercadodabola.mercadotransferencia.domain.dtos.CampeonatoDto;
import com.mercadodabola.mercadotransferencia.domain.dtos.CampeonatoTabelaDto;
import com.mercadodabola.mercadotransferencia.domain.entities.CampeonatoEntity;
import com.mercadodabola.mercadotransferencia.domain.entities.ClubeCampeonatoEntity;
import com.mercadodabola.mercadotransferencia.domain.entities.ClubeCampeonatoId;
import com.mercadodabola.mercadotransferencia.domain.entities.PartidaEntity;
import com.mercadodabola.mercadotransferencia.repositories.CampeonatoRepository;
import com.mercadodabola.mercadotransferencia.repositories.ClubeCampeonatoRepository;
import com.mercadodabola.mercadotransferencia.repositories.ClubeRepository;
import com.mercadodabola.mercadotransferencia.repositories.PartidaRepository;

@Service
public class CampeonatoService {
	
	
	
	@Autowired 
	private CampeonatoRepository campeonatoRepository;
	
	@Autowired 
	private ClubeRepository clubeRepository;
	
	@Autowired 
	private ClubeCampeonatoService clubeCampeonatoService;
	
	@Autowired
	private CampeonatoConverter campeonatoConverter;
	
	@Autowired 
	private ClubeCampeonatoRepository clubeCampeonatoRepository;
	 
	@Autowired 
	private PartidaRepository partidaRepository;
	
	CampeonatoEntity campeonatoEntity;
	
	public List<CampeonatoEntity> listar(){
		return campeonatoRepository.findAll();
	}
	
	public CampeonatoEntity salvar(CampeonatoEntity campeonato) {
		return campeonatoRepository.save(campeonato);
	}

	
	
	public CampeonatoEntity cadastrarCampeonato(CampeonatoDto campeonatoDto) {
		campeonatoEntity = new CampeonatoEntity();
		campeonatoEntity.setNomeCampeonato(campeonatoDto.getNomeDoCampeonato());
		campeonatoEntity.setQuantidadeClubes(campeonatoDto.getClubesCadastrados().size());
		campeonatoEntity.setTipoDeCampeonato(campeonatoDto.getTipoDeCampeonato());	 
		
		campeonatoEntity = campeonatoRepository.save(campeonatoEntity);
		
		campeonatoDto.getClubesCadastrados().forEach(clube -> {
						ClubeCampeonatoEntity dto = clubeCampeonatoService.cadastrarClubeCampeonato(campeonatoEntity, clube);
			//chamarmeumetodoPassandoEssesParametros(clube.getId(), campeonatoEntity.getCampeonatoId());
		});
		
		return campeonatoEntity;
		
	}
	
	public List<CampeonatoTabelaDto> listarTabela(long campeonatoId){
		List<CampeonatoTabelaDto> retorno = new ArrayList<>();
		List<PartidaEntity> listEntity = partidaRepository.findByCampeonatoId(campeonatoId);
		listEntity.forEach(partidaEntity -> {
		CampeonatoTabelaDto dto = campeonatoConverter.tabelaCampeonato(partidaEntity.getMandante(), partidaEntity);
			retorno.add(dto);
		});
		
		return retorno;
	}
	
	
	
}
