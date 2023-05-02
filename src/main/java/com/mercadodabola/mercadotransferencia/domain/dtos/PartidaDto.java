package com.mercadodabola.mercadotransferencia.domain.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PartidaDto {
	
	private Integer rodada;
	private String mandante;
	private String visitante;
	private Integer golsMandante;
	private Integer golsVisitante;
	private BigDecimal publico;
	private BigDecimal renda;
	private String dataEHora;

}
