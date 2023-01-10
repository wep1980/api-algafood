package br.com.wepdev.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;
import lombok.EqualsAndHashCode;


@JsonRootName("cozinha") // Mudando a forma de vizualização do nome Cozinha para cozinha( poderia ser qualquer outro nome ) na representação em XML
@Data // Contem, getter, setter, equals, hashcode, toString
@EqualsAndHashCode(onlyExplicitlyIncluded = true) // Substitui o equals e o hashcode do @Data informando os atributos explicitamente
@Entity
public class Cozinha {
	
	
	@EqualsAndHashCode.Include // Equals e hashcode somente com o campo Id 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//@JsonIgnore // Ignora essa propriedade, ela nao aparece na representação
	//@JsonProperty("titulo") // Customizando o nome que aparecera na representação
	@Column(nullable = false)
	private String nome;
	
	


}
