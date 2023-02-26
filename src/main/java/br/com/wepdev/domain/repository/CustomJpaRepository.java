package br.com.wepdev.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

// Classe criada que implementa metodos que fazem parte da raiz do Repository
@NoRepositoryBean // não e permitido uma implementação para essa interface
public interface CustomJpaRepository<T, ID> extends JpaRepository<T, ID>{
	
	
	Optional<T> buscarPrimeiro();

}
