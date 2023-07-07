package com.mercadodabola.mercadotransferencia.domain.converters;

import com.mercadodabola.mercadotransferencia.domain.dtos.CampeonatoTabelaDto;
import com.mercadodabola.mercadotransferencia.domain.entities.CampeonatoEntity;
import com.mercadodabola.mercadotransferencia.domain.entities.ClubeEntity;
import com.mercadodabola.mercadotransferencia.domain.entities.PartidaEntity;

public interface CampeonatoConverter {
	public CampeonatoTabelaDto tabelaCampeonato(ClubeEntity clubeEntity, CampeonatoEntity campeonatoEntity);
	
	
}
