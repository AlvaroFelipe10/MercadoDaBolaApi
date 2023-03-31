package com.mercadodabola.mercadotransferencia.domain.converters.impl;

import org.springframework.stereotype.Component;

import com.mercadodabola.mercadotransferencia.domain.converters.JogadorConverter;
import com.mercadodabola.mercadotransferencia.domain.dtos.JogadorDto;
import com.mercadodabola.mercadotransferencia.domain.entities.JogadorEntity;

@Component
public class JogadorConverterImpl implements JogadorConverter{
	public JogadorDto toJogadorDto(JogadorEntity jogadorEntity) {
		return JogadorDto.builder()
				.id(jogadorEntity.getId())
				.nome(jogadorEntity.getNome())
				.dataNascimento(jogadorEntity.getDataNascimento())
				.idade(jogadorEntity.getIdade())
				.posicao(jogadorEntity.getPosicao().name())
				.clube(jogadorEntity.getClube().getNome())
				.build();
	}

}
