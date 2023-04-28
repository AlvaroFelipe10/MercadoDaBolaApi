package com.mercadodabola.mercadotransferencia.domain.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@Entity(name = "partida")
public class PartidaEntity {
	
	@EmbeddedId
	private PartidaId id = new PartidaId();
	
	private int golsMandante;
	
	private int golsVisitante;

	private LocalDateTime dataHoraPartida;
	
	private BigDecimal publico;
	
	private BigDecimal renda;
	
	private int numeroRodada;
}
