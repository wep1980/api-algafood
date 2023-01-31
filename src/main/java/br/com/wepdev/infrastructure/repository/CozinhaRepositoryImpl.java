package br.com.wepdev.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.wepdev.domain.model.Cozinha;
import br.com.wepdev.domain.repository.CozinhaRepository;

@Repository
public class CozinhaRepositoryImpl implements CozinhaRepository {

	
	@PersistenceContext // Injetando a propria anotação do JPA, possui algumas configurações a mais
	private EntityManager manager;// Interface que gerencia o contexto de persistencia
	
	
	/**
	 * JPQL -> Linguagem de consulta do JPA, para consulta em objetos e não tabelas
	 */
	@Override
	public List<Cozinha> listar(){
		
		TypedQuery<Cozinha> query = manager.createQuery("from Cozinha", Cozinha.class);
		
		return query.getResultList();
	}
	
	/**
	 * Salva e atualiza
	 * @param cozinha
	 * @return
	 */
	@Override
	@Transactional
	public Cozinha salvarOuAtualizar(Cozinha cozinha) {
		return manager.merge(cozinha);
	}
	
	@Override
	public Cozinha buscar(Long id) {
		return manager.find(Cozinha.class, id);
	}
	
	
	@Transactional
	@Override
	public void remover(Long cozinhaId) {
		Cozinha cozinha = buscar(cozinhaId); // Colocando a instancia de cozinha no contexto de persistencia para poder ser removida
		if(cozinha == null) {
			throw new EmptyResultDataAccessException(1); // O esperado no resultado era de 1 cozinha
		}
		manager.remove(cozinha);
	}

	/*
	 * JPQL
	 */
	@Override
	public List<Cozinha> consultaPorNome(String nome) {
		
		return manager.createQuery("from Cozinha where nome like :nome", Cozinha.class)
				.setParameter("nome", "%" + nome + "%")
				.getResultList();
	}
}
