package com.mercadodabola.mercadotransferencia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercadodabola.mercadotransferencia.domain.entities.CampeonatoEntity;
import com.mercadodabola.mercadotransferencia.domain.entities.ClubeCampeonatoEntity;
import com.mercadodabola.mercadotransferencia.domain.entities.ClubeCampeonatoId;
import com.mercadodabola.mercadotransferencia.domain.entities.ClubeEntity;
import com.mercadodabola.mercadotransferencia.domain.entities.PartidaEntity;
import com.mercadodabola.mercadotransferencia.repositories.CampeonatoRepository;
import com.mercadodabola.mercadotransferencia.repositories.ClubeCampeonatoRepository;
import com.mercadodabola.mercadotransferencia.repositories.ClubeRepository;

@Service
public class ClubeCampeonatoService {
	
	@Autowired
	private ClubeCampeonatoRepository clubeCampeonatoRepository;
	
	@Autowired 
	private ClubeRepository clubeRepository;
	
	@Autowired 
	private CampeonatoRepository campeonatoRepository;
	
	@Autowired
	private PartidaService partidaService;
	
	
	public List<ClubeCampeonatoEntity> listar(){
		return clubeCampeonatoRepository.findAll();
	}
	
	public ClubeCampeonatoEntity salvar(ClubeCampeonatoEntity clubeCampeonato) {
		return clubeCampeonatoRepository.save(clubeCampeonato);
	}
	
	public ClubeCampeonatoEntity cadastrarClubeCampeonato(CampeonatoEntity campeonatoEntity, ClubeEntity clubeEntity) {
		ClubeCampeonatoEntity clubeCampeonato = new ClubeCampeonatoEntity();
		
		ClubeCampeonatoId clubeCampeonatoId = new ClubeCampeonatoId();
		clubeCampeonatoId.setCampeonatoId(campeonatoEntity);
		clubeCampeonatoId.setClubeId(clubeEntity);
		
		int quantidadeRodadas = campeonatoEntity.getQuantidadeClubes()
				* campeonatoEntity.getTipoDeCampeonato().valorTipoCampeonato
				- campeonatoEntity.getTipoDeCampeonato().valorTipoCampeonato;
		clubeCampeonato.setRodadasRestantes(quantidadeRodadas);
		
		clubeCampeonato.setId(clubeCampeonatoId);
		
		
//		
//		if(partidaEntity.getGolsMandante() > partidaEntity.getGolsVisitante()) {
//			clubeCampeonato.setPontos(+ 3);
//		} if(partidaEntity.getGolsMandante() < partidaEntity.getGolsVisitante()) {
//			clubeCampeonato.setPontos(0);
//		} if(partidaEntity.getGolsMandante() == partidaEntity.getGolsVisitante())
//			clubeCampeonato.setPontos(+ 1);
		
		
		return clubeCampeonatoRepository.save(clubeCampeonato);
		 
		
	}
	
}
