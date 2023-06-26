package com.mercadodabola.mercadotransferencia.domain.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mercadodabola.mercadotransferencia.domain.enums.TipoDeCampeonato;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@Entity(name = "campeonato")
public class CampeonatoEntity {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoDeCampeonato tipoDeCampeonato;
	
	private int quantidadeClubes;
	
	private String nomeCampeonato;
	
	@JsonIgnore
	@OneToMany
	private List<PartidaEntity> partida;
	

	 
}
