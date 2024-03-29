package br.com.wepdev.domain.infrastructure.repository;

import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import br.com.wepdev.domain.repository.CustomJpaRepository;

public class CustomJpaRepositoryImpl<T, ID> 
                                    extends SimpleJpaRepository<T, ID> 
                                    implements CustomJpaRepository<T, ID>{

	private EntityManager manager;
	
	// Construtor da classe
	public CustomJpaRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
		
		this.manager = entityManager;
	}

	@Override
	public Optional<T> buscarPrimeiro() {
		var jpql = "from " + getDomainClass().getName(); // Pegando o nome da classe para qual o repository existe
		
		T entity = manager.createQuery(jpql, getDomainClass())
		            .setMaxResults(1)
		            .getSingleResult();
		
		return Optional.ofNullable(entity);
	}
	
	
	

}
