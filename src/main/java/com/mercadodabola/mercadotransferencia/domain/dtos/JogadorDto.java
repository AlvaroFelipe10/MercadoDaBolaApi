package com.mercadodabola.mercadotransferencia.domain.dtos;

import java.time.LocalDate;

import com.mercadodabola.mercadotransferencia.domain.entities.ContratoEntity;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class JogadorDto {
	
	
	private Long id;
	private String nome;
	private LocalDate dataNascimento;
	private String posicao;
	private ContratoEntity contrato;
	private String multa;
	private LocalDate dataInicio;
	private LocalDate dataTermino;
	
}
