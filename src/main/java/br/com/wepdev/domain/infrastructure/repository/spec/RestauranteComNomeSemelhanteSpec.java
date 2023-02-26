package br.com.wepdev.domain.infrastructure.repository.spec;

import java.math.BigDecimal;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import br.com.wepdev.domain.model.Restaurante;
import lombok.AllArgsConstructor;

// Classe de Specification que representa taxaFrete igual a 0
@AllArgsConstructor
public class RestauranteComNomeSemelhanteSpec implements Specification<Restaurante>{
	private static final long serialVersionUID = 1L;

	private String nome;
	
	
	
	@Override
	public Predicate toPredicate(Root<Restaurante> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
		
		return builder.like(root.get("nome"), "%" + nome + "%");
	}

}
