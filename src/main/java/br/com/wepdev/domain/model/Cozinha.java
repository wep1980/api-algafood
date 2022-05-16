package br.com.wepdev.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

//@Getter
//@Setter
//@EqualsAndHashCode
@Data // Contem, getter, setter, equals, hashcode, toString
@EqualsAndHashCode(onlyExplicitlyIncluded = true) // Substitui o equals e o hashcode do @Data informando os atributos explicitamente
@Entity
public class Cozinha {
	
	
	@EqualsAndHashCode.Include // Equals e hashcode somente com o campo Id 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	


}
