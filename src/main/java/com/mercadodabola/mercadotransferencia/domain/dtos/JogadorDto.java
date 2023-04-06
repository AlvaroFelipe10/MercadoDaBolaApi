package com.mercadodabola.mercadotransferencia.domain.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.mercadodabola.mercadotransferencia.domain.entities.ContratoEntity;
import com.mercadodabola.mercadotransferencia.domain.util.CalculaIdade;

import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class JogadorDto {
	
	

	private Long id;
	private String nome;
	private Long idade;
	private String posicao;
	private String multa;
	private Long TempoContrato;
	
}
