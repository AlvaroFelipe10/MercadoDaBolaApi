package com.mercadodabola.mercadotransferencia.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.mercadodabola.mercadotransferencia.domain.enums.TipoDeCampeonato;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@Entity(name = "campeonato")
public class CampeonatoEntity {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long campeonatoId;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoDeCampeonato tipoDeCampeonato;
	

	private int quantidadeClubes;
	
	private String nomeCampeonato;
	

	
	 
}
