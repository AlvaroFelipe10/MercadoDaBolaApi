package com.mercadodabola.mercadotransferencia.domain.dtos;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.mercadodabola.mercadotransferencia.domain.enums.TipoGolAssist;

import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class ClubeDto {
	
	private String nome;
	
	@Enumerated(EnumType.STRING)
	private TipoGolAssist tipoGolAssist;
	
//	private Long gols;
//	
//	private Long assistencias;

}
