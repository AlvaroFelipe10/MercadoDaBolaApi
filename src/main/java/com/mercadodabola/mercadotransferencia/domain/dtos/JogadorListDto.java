package com.mercadodabola.mercadotransferencia.domain.dtos;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class JogadorListDto {
	
	private String nome;
	private String posicao;
	private String clube;
	private BigDecimal salario;


}
