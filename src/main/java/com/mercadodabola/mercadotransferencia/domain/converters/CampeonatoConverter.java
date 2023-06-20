package com.mercadodabola.mercadotransferencia.domain.converters;

import com.mercadodabola.mercadotransferencia.domain.dtos.CampeonatoTabelaDto;
import com.mercadodabola.mercadotransferencia.domain.entities.ClubeEntity;

public interface CampeonatoConverter {
	public CampeonatoTabelaDto tabelaCampeonato(ClubeEntity clubeEntity);
}
