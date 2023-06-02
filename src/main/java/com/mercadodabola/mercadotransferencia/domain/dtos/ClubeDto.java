package com.mercadodabola.mercadotransferencia.domain.dtos;

import com.mercadodabola.mercadotransferencia.domain.entities.JogadorEntity;
import com.mercadodabola.mercadotransferencia.domain.enums.Posicoes;

import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class ClubeDto {
	
	private String nome;
	
	private Long gols;
	
	private Long assistencias;

}
