package com.mercadodabola.mercadotransferencia.domain.dtos;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GolsAssistenciasDto {

	private String nome;
	
	private Long gol;
	
	private Long assistencia;
	
}
