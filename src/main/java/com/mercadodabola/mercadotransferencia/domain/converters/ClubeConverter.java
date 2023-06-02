package com.mercadodabola.mercadotransferencia.domain.converters;

import com.mercadodabola.mercadotransferencia.domain.dtos.ClubeDto;
import com.mercadodabola.mercadotransferencia.domain.entities.JogadorEntity;

public interface ClubeConverter {

	public ClubeDto listaGolAssistencia(JogadorEntity jogadorEntity); 
}
