package com.mercadodabola.mercadotransferencia.domain.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mercadodabola.mercadotransferencia.domain.enums.TipoGolAssist;

import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@Entity(name = "gol_assist_partida")
public class GolAssistPartidaEntity  {

	@EmbeddedId
	private GolAssistPartidaEntityId id = new GolAssistPartidaEntityId();
	
//	@ManyToOne
//	@JoinColumn(name = "partida_id", nullable = false)
//	private PartidaEntity partida;
//	
//	@ManyToOne(cascade=CascadeType.ALL) 
//	@JoinColumn(name = "fk_partida",nullable=false)
//	private PartidaEntity partidaId;
//	
//	@ManyToOne
//	@JoinColumn(name = "jogador_id", nullable = false )
//	private JogadorEntity idJogador;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "partida_id")
	private PartidaEntity partida;
	
	@ManyToOne
	@JoinColumn(name = "jogador_id")
	private JogadorEntity idJogador;
	
	
	@Enumerated(EnumType.STRING)
	private TipoGolAssist tipoLance;
	
}
