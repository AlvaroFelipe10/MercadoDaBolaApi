package com.mercadodabola.mercadotransferencia.domain.dtos;

import java.util.List;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mercadodabola.mercadotransferencia.domain.entities.ClubeEntity;
import com.mercadodabola.mercadotransferencia.domain.enums.TipoDeCampeonato;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CampeonatoDto {
	
	@Enumerated(EnumType.STRING)
	private TipoDeCampeonato tipoDeCampeonato;
	
	private int quantidadeClubes;
	
	private String nomeDoCampeonato;
	 
	@JsonIgnoreProperties({"nome", "caixa", "estadio"})
	private List<ClubeEntity> clubesCadastrados;

}
