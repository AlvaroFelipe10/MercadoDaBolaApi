package com.mercadodabola.mercadotransferencia.domain.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@Entity(name = "clube_campeonato")
public class ClubeCampeonatoEntity {
	
	@EmbeddedId
    private ClubeCampeonatoId id = new ClubeCampeonatoId();
	
//	
//	@OneToOne
//	@JoinColumn(name = "clube_id", nullable = false)
//	private ClubeEntity clubeId;
//	
//	@OneToOne
//	@JoinColumn(name = "campeonato_id", nullable = false)
//	private CampeonatoEntity campeonatoId;
	
	private Long pontos;
}
