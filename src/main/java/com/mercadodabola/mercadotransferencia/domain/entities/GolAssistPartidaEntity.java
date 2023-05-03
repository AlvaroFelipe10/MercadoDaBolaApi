package com.mercadodabola.mercadotransferencia.domain.entities;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;

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
	@OneToOne
	private  PartidaEntity partida;
	
	@OneToOne
	@JoinColumn(name = "jogador_id", nullable = false)
	private JogadorEntity jogadorId;
	
	private String minutoSegundos;
	
	private TipoGolAssist golAssist;
	
}
