package com.mercadodabola.mercadotransferencia.domain.dtos;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class JogadorDto {
	
	
	private Long id;
	private String nome;
	private LocalDate dataNascimento;
	private String posicao;
	private String clube;
	
}
