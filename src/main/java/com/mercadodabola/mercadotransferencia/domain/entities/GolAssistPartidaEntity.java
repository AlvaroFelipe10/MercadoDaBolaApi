package com.mercadodabola.mercadotransferencia.domain.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.mercadodabola.mercadotransferencia.domain.enums.TipoGolAssist;

import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@Entity(name = "gol_assist_partida")
public class GolAssistPartidaEntity  {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long golAssistPartidaId;
	
//	@ManyToOne
//	private PartidaEntity partidaId;
	
	@ManyToOne
	@JoinColumn(name = "jogador_id", nullable = false)
	private JogadorEntity jogador ;
	
	private String minutoSegundos;
	
	@Enumerated(EnumType.STRING)
	private TipoGolAssist tipoGolAssist;
	
}
