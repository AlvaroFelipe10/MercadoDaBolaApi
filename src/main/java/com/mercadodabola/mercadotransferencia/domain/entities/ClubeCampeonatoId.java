package com.mercadodabola.mercadotransferencia.domain.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@Embeddable
public class ClubeCampeonatoId implements Serializable {


    @ManyToOne @JoinColumn(name = "clube_id")
	private ClubeEntity clubeId;
	
    @ManyToOne @JoinColumn(name = "campeonato_id")
	private CampeonatoEntity campeonatoId;
	
   
}
