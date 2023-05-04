package com.mercadodabola.mercadotransferencia.domain.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@Entity(name = "partida")
public class PartidaEntity {
	
	@EmbeddedId
	private PartidaId id = new PartidaId();
	
	private Long golsMandante;
	
	private Long golsVisitante;
	@JsonDeserialize(as = LocalDateTime.class)
	private LocalDateTime dataHoraPartida;
	
	private BigDecimal publico;
	
	private BigDecimal renda;
	
	private int numeroRodada;
}
