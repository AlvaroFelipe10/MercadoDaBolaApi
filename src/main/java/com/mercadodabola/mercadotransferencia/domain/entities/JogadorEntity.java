package com.mercadodabola.mercadotransferencia.domain.entities;



import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.mercadodabola.mercadotransferencia.domain.enums.Posicoes;

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
	private LocalDate dataNascimento;

	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Posicoes posicao;
	
	
	@Valid
	@NotNull
	//@JsonIgnoreProperties(value="jogadores", allowSetters = true)
	@ManyToOne//(fetch = FetchType.LAZY)
	@JoinColumn(name = "clube_id", nullable = false)
	private ClubeEntity clube;

}
