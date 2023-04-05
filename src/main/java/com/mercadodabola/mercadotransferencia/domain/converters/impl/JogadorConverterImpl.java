package com.mercadodabola.mercadotransferencia.domain.converters.impl;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import org.springframework.stereotype.Component;

import com.mercadodabola.mercadotransferencia.domain.converters.JogadorConverter;
import com.mercadodabola.mercadotransferencia.domain.dtos.JogadorDto;
import com.mercadodabola.mercadotransferencia.domain.entities.JogadorEntity;


@Component
public class JogadorConverterImpl implements JogadorConverter{
	public JogadorDto toJogadorDto(JogadorEntity jogadorEntity) {
		JogadorDto retorno = JogadorDto.builder()
									.id(jogadorEntity.getId())
									.nome(jogadorEntity.getNome())
									.posicao(jogadorEntity.getPosicao().name())
									.build();
		
			
		if(jogadorEntity.getContrato() != null) {
			retorno.setMulta(valorReal(jogadorEntity.getContrato().getValorMulta()));;
		}
		return retorno;
	}
	
	
	
	private String valorReal(BigDecimal multa) {
		DecimalFormat decFormat = new DecimalFormat("#,###,##0.00");
		return decFormat.format(multa);
		
	}

}
