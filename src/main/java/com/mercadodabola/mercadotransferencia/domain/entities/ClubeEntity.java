package com.mercadodabola.mercadotransferencia.domain.entities;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

//@JsonRootName("clube")
@Data
@Entity(name = "clube")
public class ClubeEntity {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private BigDecimal caixa;

//	@JsonIgnore
	//@JsonIgnoreProperties(value="clube", allowSetters = true)
//	@OneToMany(mappedBy = "clube")
//	private List<JogadorEntity> jogadores = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "clube")
	private  List<ContratoEntity> contrato;
}
