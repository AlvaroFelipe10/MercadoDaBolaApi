package com.mercadodabola.mercadotransferencia.domain.dtos;

import com.mercadodabola.mercadotransferencia.domain.enums.Posicoes;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ClubeDto {
	
	private String nomeJogador;
	private Posicoes posicao;
	

}
