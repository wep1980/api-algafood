package br.com.wepdev.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.wepdev.domain.model.Cozinha;

@Repository
public interface CozinhaRepository extends CustomJpaRepository<Cozinha, Long>{

	
	List<Cozinha> findBynome(String nome);
	List<Cozinha> findQualquerCoisaBynome(String nome);
	
	// Containing - dentro dele possui um like com % antes e % depois
	List<Cozinha> findTodasByNomeContaining(String nome);

	// se a cozinha existir retorna true, senão retorna false
	boolean existsByNome(String nome);
	
}
