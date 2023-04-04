package com.mercadodabola.mercadotransferencia.domain.converters.impl;



import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.springframework.stereotype.Component;

import com.mercadodabola.mercadotransferencia.domain.converters.JogadorConverter;
import com.mercadodabola.mercadotransferencia.domain.dtos.JogadorDto;
import com.mercadodabola.mercadotransferencia.domain.entities.ContratoEntity;
import com.mercadodabola.mercadotransferencia.domain.entities.JogadorEntity;

@Component
public class JogadorConverterImpl implements JogadorConverter{
	public JogadorDto toJogadorDto(JogadorEntity jogadorEntity) {
		JogadorDto retorno = JogadorDto.builder()
									.id(jogadorEntity.getId())
									.nome(jogadorEntity.getNome())
									.dataNascimento(jogadorEntity.getDataNascimento())
									.posicao(jogadorEntity.getPosicao().name())
									.build();
				
		
		return retorno;
	}
	
//	.multa(valorReal(jogadorEntity.getContrato().getValorMulta()))
	
	
	private String valorReal(BigDecimal multa) {
		DecimalFormat decFormat = new DecimalFormat("#,###,##0.00");
		return decFormat.format(multa);
		
		
		
	}

}
