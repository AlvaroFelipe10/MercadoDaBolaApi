package com.mercadodabola.mercadotransferencia.domain.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity(name="contrato")
public class ContratoEntity {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@JsonDeserialize(as = LocalDate.class)
	@Column(nullable = false)
	private	LocalDate dataInicio;
	
	@NotNull
	@JsonDeserialize(as = LocalDate.class)
	@Column(nullable = false)
	private LocalDate dataTermino;
	
	@Column(nullable = false)
	private BigDecimal valorMulta;
	
	@Column(nullable = false)
	private BigDecimal salario;
	
	@OneToOne
	@JoinColumn(name = "jogador_id", nullable = false)
	private JogadorEntity jogador;
	
	
	@Valid
	@NotNull
	@JsonIgnore
	//@JsonIgnoreProperties(value="jogadores", allowSetters = true)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clube_id", nullable = false)
	private ClubeEntity clube;
	
	
}
