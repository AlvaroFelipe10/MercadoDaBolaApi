package com.mercadodabola.mercadotransferencia.domain.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
	private LocalDateTime dataEHora;
	@Enumerated(EnumType.STRING)
	private List<GolAssistenciaDto> golAssistencia;

}
