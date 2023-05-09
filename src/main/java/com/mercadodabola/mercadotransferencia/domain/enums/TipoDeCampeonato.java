package com.mercadodabola.mercadotransferencia.domain.enums;

public enum TipoDeCampeonato {
	
	PONTOS_CORRIDOS(1),
	MATA_MATA(1),
	MATA_MATA_IDA_VOLTA(2),
	PONTOS_CORRIDOS_IDA_VOLTA (2);

	public int valorTipoCampeonato;
	TipoDeCampeonato(int valor){
		valorTipoCampeonato = valor;
	}
}
