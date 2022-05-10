package br.com.wepdev.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.wepdev.domain.model.Cozinha;

@Component
public class CadastroCozinha {
	
	@PersistenceContext // Injetando a propria anotação do JPA, possui algumas configurações a mais
	private EntityManager manager;// Interface que gerencia o contexto de persistencia
	
	
	/**
	 * JPQL -> Linguagem de consulta do JPA, para consulta em objetos e não tabelas
	 */
	public List<Cozinha> listar(){
		
		TypedQuery<Cozinha> query = manager.createQuery("from Cozinha", Cozinha.class);
		
		return query.getResultList();
	}
	
	/**
	 * Salva e atualiza
	 * @param cozinha
	 * @return
	 */
	@Transactional
	public Cozinha salvar(Cozinha cozinha) {
		return manager.merge(cozinha);
	}
	
	
	public Cozinha buscar(Long id) {
		return manager.find(Cozinha.class, id);
	}

}


