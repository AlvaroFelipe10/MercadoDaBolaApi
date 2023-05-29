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
	@JoinColumn(name = "partida_id")	
	private PartidaEntity partida;
	
	@ManyToOne
	@JoinColumn(name = "jogador_id")
	private JogadorEntity idJogador;

}
