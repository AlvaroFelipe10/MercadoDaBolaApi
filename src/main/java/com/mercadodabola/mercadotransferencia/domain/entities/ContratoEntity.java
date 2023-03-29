package com.mercadodabola.mercadotransferencia.domain.entities;

import java.math.BigDecimal;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity(name="contrato")
public class ContratoEntity {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private	String dataInicio;
	
	@Column(nullable = false)
	private String dataTermino;
	
	@Column(nullable = false)
	private BigDecimal valorMulta;
	
	@Column(nullable = false)
	private BigDecimal salario;
	
	@OneToOne
	@JoinColumn(name = "jogador_id", nullable = false)
	private JogadorEntity Jogador;
	
	@OneToOne
	@JoinColumn(name = "clube_id", nullable = false)
	private ClubeEntity Clube;
	
	
	
}
