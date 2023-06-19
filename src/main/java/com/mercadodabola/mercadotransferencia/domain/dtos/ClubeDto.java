package com.mercadodabola.mercadotransferencia.domain.dtos;

import java.util.List;

import com.mercadodabola.mercadotransferencia.domain.entities.GolAssistPartidaEntity;

import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class ClubeDto {
	
	private String nome;
		
	private Long golsCarreira;
	
	private Long assistenciasCarreira;
	
	private Long golsClube;
	
	private Long assistenciasClube;
	
}
