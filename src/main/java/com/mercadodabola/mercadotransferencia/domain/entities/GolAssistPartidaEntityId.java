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
public class GolAssistPartidaEntityId implements Serializable{
	
	
	@ManyToOne 
	@JoinColumn(name = "clube_id")
	private ClubeEntity clube;

	
	private String minutoSegundos;
}
