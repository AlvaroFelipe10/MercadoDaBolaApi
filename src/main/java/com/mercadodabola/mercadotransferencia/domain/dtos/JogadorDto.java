package com.mercadodabola.mercadotransferencia.domain.dtos;

import com.mercadodabola.mercadotransferencia.domain.enums.Posicoes;

import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class JogadorDto {
	
	

	private Long id;
	private String nome;
	private Integer idade;
	private Posicoes posicao;
	private String multa;
	private String tempoContrato;
	
	
}
