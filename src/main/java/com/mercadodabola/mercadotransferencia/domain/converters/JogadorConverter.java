package com.mercadodabola.mercadotransferencia.domain.converters;

import com.mercadodabola.mercadotransferencia.domain.dtos.JogadorDto;
import com.mercadodabola.mercadotransferencia.domain.entities.JogadorEntity;

public interface JogadorConverter {
	public JogadorDto toJogadorDto(JogadorEntity jogadorEntity);

}
