package com.mercadodabola.mercadotransferencia.domain.dtos;

import java.util.List;

import org.springframework.beans.BeanUtils;

import com.mercadodabola.mercadotransferencia.domain.entities.ClubeEntity;
import com.mercadodabola.mercadotransferencia.domain.entities.JogadorEntity;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class JogadorDto {
	
	
	private Long id;
	private String nome;
	private String dataNascimento;
	private String posicao;
	private String clube;
	
}
