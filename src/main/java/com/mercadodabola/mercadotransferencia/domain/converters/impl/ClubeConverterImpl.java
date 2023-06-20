package com.mercadodabola.mercadotransferencia.domain.converters.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mercadodabola.mercadotransferencia.domain.converters.ClubeConverter;
import com.mercadodabola.mercadotransferencia.domain.dtos.ClubeDto;
import com.mercadodabola.mercadotransferencia.domain.entities.JogadorEntity;
import com.mercadodabola.mercadotransferencia.repositories.GolAssistPartidaRepository;

@Component
public class ClubeConverterImpl implements ClubeConverter {

	@Autowired
	GolAssistPartidaRepository golAssistRepository;

	public ClubeDto listaClubeDto(JogadorEntity jogadorEntity) {
		ClubeDto retorno = ClubeDto.builder()
				.nome(jogadorEntity.getNome())
				.build();
		retorno.setGolsClube(golAssistRepository.qtdGolsClube(jogadorEntity.getContrato().getClube().getId(), jogadorEntity.getId()));
		retorno.setAssistenciasClube(golAssistRepository.qtdAssistenciasClube(jogadorEntity.getContrato().getClube().getId(), jogadorEntity.getId()));
		retorno.setAssistenciasCarreira(golAssistRepository.qtdAssistenciasCarreira(jogadorEntity.getId()));
		retorno.setGolsCarreira(golAssistRepository.qtdGolsCarreira(jogadorEntity.getId()));
		if(retorno.getAssistenciasCarreira() == null)
			retorno.setAssistenciasCarreira((long) 0);
		if(retorno.getAssistenciasClube() == null)
			retorno.setAssistenciasClube((long) 0);
		if(retorno.getGolsCarreira() == null)
			retorno.setGolsCarreira((long) 0);
		if(retorno.getGolsClube() == null)
			retorno.setGolsClube((long) 0);
		return retorno;
	}
	
 
}
