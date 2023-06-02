package com.mercadodabola.mercadotransferencia.domain.dtos;

import com.mercadodabola.mercadotransferencia.domain.enums.Posicoes;
import com.mercadodabola.mercadotransferencia.domain.enums.TipoGolAssist;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ListaJogadorPorClubeIdDto {
	
	private String nomeJogador;
	private Posicoes posicao;
	private TipoGolAssist tipoLance;

}
