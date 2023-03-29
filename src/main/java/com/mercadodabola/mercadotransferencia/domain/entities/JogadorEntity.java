package com.mercadodabola.mercadotransferencia.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity(name = "jogador")
public class JogadorEntity {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private String dataNascimento;

	@Column(nullable = false)
	private String posicao;

	@JsonIgnoreProperties(value="jogadores", allowSetters = true)
	@ManyToOne//(fetch = FetchType.LAZY)
	@JoinColumn(name = "clube_id", nullable = false)
	private ClubeEntity clube;

}
