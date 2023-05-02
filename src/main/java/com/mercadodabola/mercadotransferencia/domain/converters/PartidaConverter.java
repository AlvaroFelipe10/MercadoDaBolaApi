package com.mercadodabola.mercadotransferencia.domain.converters;


import com.mercadodabola.mercadotransferencia.domain.dtos.PartidaDto;
import com.mercadodabola.mercadotransferencia.domain.entities.PartidaEntity;

public interface PartidaConverter {
	
	public PartidaDto listPartida(PartidaEntity partidaEntity);
}
