package br.com.wepdev.domain.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Restaurante {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(name = "taxa_frete", nullable = false)
	private BigDecimal taxaFrete;
	
	
	@ManyToOne // Muitos restaurantes possue 1 cozinha
	@JoinColumn(name = "cozinha_id", nullable = false) // Forma de colocar um novo nome no nome da coluna quando possui relacionamento com outra tabela
	private Cozinha cozinha;
	
	
	 // muitos restaurantes possuem muitas formas de pegamento
	@ManyToMany
	@JoinTable(name = "restaurante_forma_pagamento", // mapeamento e referencia dos campos na tabela que sera criada quando existe um relacionamento de muitos pra muitos
	       joinColumns = @JoinColumn(name = "restaurante_id"),
	       inverseJoinColumns = @JoinColumn(name = "forma_pagamento_id"))
	@JsonIgnore
	private List<FormaPagamento> formasPagamento = new ArrayList<>();

}
