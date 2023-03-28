package com.mercadodabola.mercadotransferencia.domain.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
public class Jogador {

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
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "clube_id", nullable = false)
	private Clube clube;
}
