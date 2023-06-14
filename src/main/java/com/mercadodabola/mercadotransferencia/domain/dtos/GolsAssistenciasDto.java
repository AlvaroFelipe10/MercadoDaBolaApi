package com.mercadodabola.mercadotransferencia.domain.dtos;

import com.mercadodabola.mercadotransferencia.domain.enums.TipoGolAssist;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GolsAssistenciasDto {
	
	private String nomeJogador;
	
	private TipoGolAssist gol;
	
	private TipoGolAssist assistencia;

}
