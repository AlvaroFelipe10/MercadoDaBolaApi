package com.mercadodabola.mercadotransferencia.domain.converters.impl;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mercadodabola.mercadotransferencia.domain.converters.JogadorConverter;
import com.mercadodabola.mercadotransferencia.domain.dtos.ClubeDto;
import com.mercadodabola.mercadotransferencia.domain.dtos.JogadorDto;
import com.mercadodabola.mercadotransferencia.domain.dtos.JogadorListDto;
import com.mercadodabola.mercadotransferencia.domain.dtos.ListaJogadorPorClubeIdDto;
import com.mercadodabola.mercadotransferencia.domain.entities.JogadorEntity;
import com.mercadodabola.mercadotransferencia.domain.util.CalculaIdade;
import com.mercadodabola.mercadotransferencia.domain.util.CalculaTempoContrato;
import com.mercadodabola.mercadotransferencia.repositories.GolAssistPartidaRepository;


@Component
public class JogadorConverterImpl implements JogadorConverter{
	
	@Autowired
	private CalculaIdade calculaIdade;
	
	@Autowired
	private CalculaTempoContrato calculaContrato;
	
	@Autowired
	private GolAssistPartidaRepository golAssistRepository;
		
	
	public JogadorDto toJogadorDto(JogadorEntity jogadorEntity) {
		JogadorDto retorno = JogadorDto.builder()
									.id(jogadorEntity.getId())
									.nome(jogadorEntity.getNome())
									.posicao(jogadorEntity.getPosicao())
									.build();
		retorno.setIdade(calculaIdade.getIdade(jogadorEntity.getDataNascimento()));

		retorno.setTempoContrato(calculaContrato.getTempoRestante(jogadorEntity.getContrato().getDataInicio(),jogadorEntity.getContrato().getDataTermino() ));
		
		if(jogadorEntity.getContrato() != null) {
			retorno.setMulta(valorReal(jogadorEntity.getContrato().getValorMulta()));;
		}
		return retorno;	
	}
	
//	public JogadorListDto listToJogadorDto(String nome) {
//		JogadorEntity jogadorEntity = new JogadorEntity();
//		JogadorListDto retorno = JogadorListDto.builder()
//				.nome(jogadorEntity.getNome())
//				.posicao(jogadorEntity.getPosicao().name())
//				.build();
//		retorno.setClube(jogadorEntity.getContrato().getClube().getNome());
//		return retorno;
//		
//	}

	public JogadorListDto listToJogadorDto(JogadorEntity jogadorEntity) {
		JogadorListDto retorno = JogadorListDto.builder()
				.nome(jogadorEntity.getNome())
				.posicao(jogadorEntity.getPosicao().name())
				.build();
	
		retorno.setClube(jogadorEntity.getContrato().getClube().getNome());
		retorno.setSalario(jogadorEntity.getContrato().getSalario());
		return retorno;
	}
	
	public ListaJogadorPorClubeIdDto listToJogadorPorIdClube(JogadorEntity jogadorEntity) {
		ListaJogadorPorClubeIdDto retorno = ListaJogadorPorClubeIdDto.builder()
				.nomeJogador(jogadorEntity.getNome())
				.posicao(jogadorEntity.getPosicao())
				.build();
		return retorno;
	}
	
	private String valorReal(BigDecimal multa) {
		DecimalFormat decFormat = new DecimalFormat("#,###,##0.00");
		return decFormat.format(multa);
		
	}


}
