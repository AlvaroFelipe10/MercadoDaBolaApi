package com.mercadodabola.mercadotransferencia.domain.dtos;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CampeonatoTabelaDto {
	
	private String nome;
	
	private long vitorias;
	
	private Long derrotas;
	
	private Long empates;

	private Long pontos;
	
	private long golsSofridos;
	
	private long golsFeitos;
	
	private long saldoDeGols;

}
