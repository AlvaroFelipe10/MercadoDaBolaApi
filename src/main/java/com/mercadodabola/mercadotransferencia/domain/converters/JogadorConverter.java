package com.mercadodabola.mercadotransferencia.domain.converters;


import com.mercadodabola.mercadotransferencia.domain.dtos.ClubeDto;
import com.mercadodabola.mercadotransferencia.domain.dtos.JogadorDto;
import com.mercadodabola.mercadotransferencia.domain.dtos.JogadorListDto;
import com.mercadodabola.mercadotransferencia.domain.entities.ContratoEntity;
import com.mercadodabola.mercadotransferencia.domain.entities.JogadorEntity;

public interface JogadorConverter {
	public JogadorDto toJogadorDto(JogadorEntity jogadorEntity);

	public JogadorListDto listToJogadorDto(JogadorEntity jogadorEntity);
	
	public ClubeDto listToClube(ContratoEntity contratoEntity);
	
	
}
