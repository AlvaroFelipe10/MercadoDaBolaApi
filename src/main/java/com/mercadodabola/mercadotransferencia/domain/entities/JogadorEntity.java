package com.mercadodabola.mercadotransferencia.domain.entities;



import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.mercadodabola.mercadotransferencia.domain.enums.Posicoes;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Component
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@Entity(name = "jogador")
public class JogadorEntity {


	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Column(nullable = false)
	private String nome;

	@NotNull
	@JsonDeserialize(as = LocalDate.class)
	@Column(nullable = false)
	private LocalDate dataNascimento;

	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Posicoes posicao;
	
	
	@JsonIgnore
	@OneToOne
	private ContratoEntity contrato;
	
//	@ManyToMany
//	private List<GolAssistPartidaEntity> golAssistencia; 

}
