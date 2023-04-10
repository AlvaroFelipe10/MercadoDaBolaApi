package com.mercadodabola.mercadotransferencia.domain.converters.impl;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mercadodabola.mercadotransferencia.domain.converters.JogadorConverter;
import com.mercadodabola.mercadotransferencia.domain.dtos.JogadorDto;
import com.mercadodabola.mercadotransferencia.domain.entities.ContratoEntity;
import com.mercadodabola.mercadotransferencia.domain.entities.JogadorEntity;
import com.mercadodabola.mercadotransferencia.domain.util.CalculaIdade;
import com.mercadodabola.mercadotransferencia.domain.util.CalculaTempoContrato;



@Component
public class JogadorConverterImpl implements JogadorConverter{
	
	@Autowired
	private CalculaIdade calculaIdade;
	
	@Autowired
	private CalculaTempoContrato calculaContrato;
	
	
	public JogadorDto toJogadorDto(JogadorEntity jogadorEntity) {
		JogadorDto retorno = JogadorDto.builder()
									.id(jogadorEntity.getId())
									.nome(jogadorEntity.getNome())
									.posicao(jogadorEntity.getPosicao().name())
									.build();
		
		
		retorno.setIdade(calculaIdade.getIdade(jogadorEntity.getDataNascimento()));

		retorno.setTempoContrato(calculaContrato.getTempoRestante(jogadorEntity.getContrato().getDataInicio(),jogadorEntity.getContrato().getDataTermino() ));
		
		if(jogadorEntity.getContrato() != null) {
			retorno.setMulta(valorReal(jogadorEntity.getContrato().getValorMulta()));;
		}
		return retorno;	
	}
	
	

//	private Long calculo(LocalDate dataNascimento) {
//		CalculaIdade calculaIdade = new CalculaIdade();
//		calculaIdade.getIdade(dataNascimento);
//		Long idade = calculaIdade.getIdade(dataNascimento);
//		return idade;
//	}
	

	private String valorReal(BigDecimal multa) {
		DecimalFormat decFormat = new DecimalFormat("#,###,##0.00");
		return decFormat.format(multa);
		
	}

}
