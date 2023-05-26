package com.mercadodabola.mercadotransferencia.domain.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

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
	
	private String minutoSegundos;
	
	@Enumerated(EnumType.STRING)
	private TipoGolAssist tipoLance;
	
}
