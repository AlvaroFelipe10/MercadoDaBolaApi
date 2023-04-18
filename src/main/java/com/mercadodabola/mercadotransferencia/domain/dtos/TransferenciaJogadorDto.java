package com.mercadodabola.mercadotransferencia.domain.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TransferenciaJogadorDto {

	//@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate dataInicio;
	//@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate dataTermino;
	private Long clubeOrigemId;
	private Long clubeDestinoId;
	private Long jogadorId;
	private BigDecimal multa;
	private BigDecimal valorDaTransferencia;
	private BigDecimal salario;
}
