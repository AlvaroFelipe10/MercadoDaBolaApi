package com.mercadodabola.mercadotransferencia.domain.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@Entity(name = "partida")
public class PartidaEntity {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne @JoinColumn(name = "mandante_id")
	private ClubeEntity mandante;
	
	@ManyToOne @JoinColumn(name = "visitante_id")
	private ClubeEntity visitante;
	
	@ManyToOne @JoinColumn(name = "campeonato_id")
	private CampeonatoEntity campeonato;

	
	private Long golsMandante;
	
	private Long golsVisitante;
	@JsonDeserialize(as = LocalDateTime.class)
	private LocalDateTime dataHoraPartida;
	
	private BigDecimal publico;
	
	private BigDecimal renda;
	
	private int numeroRodada;
	
	@JsonIgnore
	@OneToMany
	private List<GolAssistPartidaEntity> golAssistencia;
}
