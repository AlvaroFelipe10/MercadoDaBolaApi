package com.mercadodabola.mercadotransferencia.domain.dtos;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CampeonatoTabelaDto {
	
	private String nome;
	
	private Long vitorias;
	
	private Long derrotas;
	
	private Long empates;

	private Long pontos;
	
	private Long golsSofridos;
	
	private Long golsFeitos;
	
	private Long saldoDeGols;

}
