package com.mercadodabola.mercadotransferencia.domain.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
	
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	private PartidaEntity partida;
	
	@ManyToOne
	@JoinColumn(name = "jogador_id", nullable = false)
	private JogadorEntity jogadorId;
	
	private String minutoSegundos;
	
	private TipoGolAssist golAssist;
	
}
