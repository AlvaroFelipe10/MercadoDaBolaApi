package com.mercadodabola.mercadotransferencia.domain.converters;

import com.mercadodabola.mercadotransferencia.domain.dtos.GolsAssistenciasDto;
import com.mercadodabola.mercadotransferencia.domain.entities.GolAssistPartidaEntity;

public interface GolsAssistenciasConverter {
	
	public GolsAssistenciasDto listaGolsAssistencias(GolAssistPartidaEntity golAssist);

}
