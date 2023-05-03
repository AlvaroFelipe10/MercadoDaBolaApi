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
public class PartidaId implements Serializable{
	
	
	@ManyToOne @JoinColumn(name = "mandante_id")
	private ClubeEntity mandante;
	
	@ManyToOne @JoinColumn(name = "visitante_id")
	private ClubeEntity visitante;
	
	@ManyToOne @JoinColumn(name = "campeonato_id")
	private CampeonatoEntity campeonato;

	
}
