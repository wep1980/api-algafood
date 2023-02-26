package br.com.wepdev.domain.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.wepdev.domain.model.Restaurante;

@Repository
public interface RestauranteRepository extends 
                                       CustomJpaRepository<Restaurante, Long>, 
                                       RestauranteRepositoryQueries, 
                                       JpaSpecificationExecutor<Restaurante>{


	List<Restaurante> findByTaxaFreteBetween(BigDecimal taxaInicial, BigDecimal TaxaFinal);
	
	// Containing - dentro dele possui um like com % antes e % depois -- buscar restaurante por nome e cozinhaId
	List<Restaurante> findByNomeContainingAndCozinhaId(String nome, Long cozinhaId);
	
	// Mesma consulta acima, com implementação JPQL
	//@Query("from Restaurante where nome like %:nome% and cozinha.id = :id") // Query colocada em um arquivo xml
	List<Restaurante> consultarPorNome(String nome, @Param("id") Long cozinha);
	
	// Retorna o primeiro restaurante pelo nome
	Optional<Restaurante> findFirstRestauranteByNomeContaining(String nome);
	
	// retorna os 2 primeiros restaurantes pelo nome
	List<Restaurante> findTop2ByNomeContaining(String nome);
	
	// retorna a quantidade total de restaurantes por tipo de cozinhas
	int countByCozinhaId(Long cozinhaId);
	
}
