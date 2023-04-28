package com.mercadodabola.mercadotransferencia.domain.entities;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@Entity(name = "estadio")
public class EstadioEntity {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long estadioId;
	
	private String nome;
	
	private BigDecimal capacidadeMaxima;
	
	@JsonIgnoreProperties({"caixa", "nome", "estadio"})
	@OneToOne
	@JoinColumn(name = "clube_id", nullable = false)
	private ClubeEntity clube;
}
