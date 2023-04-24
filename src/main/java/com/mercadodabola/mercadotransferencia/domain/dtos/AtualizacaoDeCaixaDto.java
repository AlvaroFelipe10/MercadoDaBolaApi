package com.mercadodabola.mercadotransferencia.domain.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AtualizacaoDeCaixaDto {
	
	private Long clubeId;
	private BigDecimal faturamentoBilheteria;
	private BigDecimal faturamentoPatrocinio;


}
