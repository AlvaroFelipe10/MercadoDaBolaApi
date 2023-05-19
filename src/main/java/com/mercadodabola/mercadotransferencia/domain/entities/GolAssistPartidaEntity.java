package com.mercadodabola.mercadotransferencia.domain.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.mercadodabola.mercadotransferencia.domain.enums.TipoGolAssist;

import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@Entity(name = "gol_assist_partida")
public class GolAssistPartidaEntity {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long golAssistPartidaId;
	
	
	//private PartidaEntity partida;
	 
	
	private long jogadorId;
	
	private String minutoSegundos;
	
	private TipoGolAssist golAssist;
	
}
