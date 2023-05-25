package com.mercadodabola.mercadotransferencia.domain.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mercadodabola.mercadotransferencia.domain.entities.JogadorEntity;
import com.mercadodabola.mercadotransferencia.domain.enums.MandanteOuVisitante;
import com.mercadodabola.mercadotransferencia.domain.enums.TipoGolAssist;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GolAssistenciaDto {

	private long golAssistPartidaId;
	private String minutoSegundo;
	
	private long idJogador;
	private TipoGolAssist tipoLance;
	private MandanteOuVisitante mandanteOuVisitante;
}
