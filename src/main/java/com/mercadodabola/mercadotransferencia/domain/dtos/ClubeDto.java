package com.mercadodabola.mercadotransferencia.domain.dtos;

import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class ClubeDto {
	
	private String nome;
		
	private Long gols;
	
	private Long assistencias;
	
}
