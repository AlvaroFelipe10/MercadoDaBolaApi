package com.mercadodabola.mercadotransferencia.domain.dtos;

import java.math.BigDecimal;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PartidaDto {
	
	private Integer rodada;
	private Long mandanteId;
	private Long visitanteId;
	private Long campeonatoId;
	private BigDecimal publico;
	private BigDecimal renda;
	private String dataEHora;
	private List<GolAssistenciaDto> golAssistencia;

}
