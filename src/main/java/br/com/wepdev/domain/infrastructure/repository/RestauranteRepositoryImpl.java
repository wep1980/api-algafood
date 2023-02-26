package br.com.wepdev.domain.infrastructure.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import br.com.wepdev.domain.infrastructure.repository.spec.RestauranteSpecs;
import br.com.wepdev.domain.model.Restaurante;
import br.com.wepdev.domain.repository.RestauranteRepository;
import br.com.wepdev.domain.repository.RestauranteRepositoryQueries;

@Repository
public class RestauranteRepositoryImpl implements RestauranteRepositoryQueries {
	
	private static final String restauranteRepository = null;
	
	@PersistenceContext
	private EntityManager manager;
	
	@Autowired @Lazy // Lazy evita a dependencia circular, referente a um repository depender dele mesmo(Ou seja essa dependencia so sera instanciada qnd for preciso)
	private RestauranteRepository repository;
	
	
//	@Override
//	public List<Restaurante> find(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal){
//		var jpql = "from Restaurante where nome like :nome and taxaFrete between :taxaInicial and :taxaFinal";
//		
//		return manager.createQuery(jpql, Restaurante.class)
//				.setParameter("nome", "%" + nome + "%")
//				.setParameter("taxaInicial", taxaFreteInicial)
//				.setParameter("taxaFinal", taxaFreteFinal)
//				.getResultList();
//	}
	
	/*
	 * Consulta dinamica com JPQL
	 */
//	@Override
//	public List<Restaurante> find(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal){
//		
//		var jpql = new StringBuilder();
//		jpql.append("from Restaurante where 0 = 0 ");
//		
//		var parametros = new HashMap<String, Object>(); // A chave e uma String e o valor e um Object
//		
//		if(StringUtils.hasLength(nome)) { // StringUtils.hasLength -> verifica se não esta nulo e se não esta vazio
//			jpql.append("and nome like :nome ");
//			parametros.put("nome", "%" + nome + "%");
//		}
//		if(taxaFreteInicial != null) { 
//			jpql.append("and taxaFrete >= :taxaInicial ");
//			parametros.put("taxaInicial", taxaFreteInicial);
//		}
//		if(taxaFreteFinal != null) { 
//			jpql.append("and taxaFrete <= :taxaFinal ");
//			parametros.put("taxaFinal", taxaFreteFinal);
//		}
//		
//		TypedQuery<Restaurante> query = manager.createQuery(jpql.toString(), Restaurante.class);
//		
//		parametros.forEach((chave, valor)-> query.setParameter(chave, valor));
//		
//		return query.getResultList();
//	}
	

	/*
	 * Consulta simples com criteria APi
	 */
//	@Override
//	public List<Restaurante> find(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal){
//		
//		CriteriaBuilder builder = manager.getCriteriaBuilder();
//		
//		CriteriaQuery<Restaurante> criteria = builder.createQuery(Restaurante.class);
//		
//		criteria.from(Restaurante.class);
//		
//		TypedQuery<Restaurante> query = manager.createQuery(criteria);
//		
//		return query.getResultList();
//	}
	
	/*
	 * Consulta com filtros
	 */

	
	/*
	 * Consulta com criteria e filtros
	 */
//	@Override
//	public List<Restaurante> find(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal){
//		
//		CriteriaBuilder builder = manager.getCriteriaBuilder();
//		
//		CriteriaQuery<Restaurante> criteria = builder.createQuery(Restaurante.class);
//		
//		Root<Restaurante> root = criteria.from(Restaurante.class);
//		
//		Predicate nomePredicate = builder.like(root.get("nome"), "%" + nome + "%");
//		
//		// greaterThanOrEqualTo -> taxaFrete tem que ser maior ou igual a taxaFreteInicial
//		Predicate taxaInicialPredicate = builder.greaterThanOrEqualTo(root.get("taxaFrete"), taxaFreteInicial);
//		
//		// taxaFrete tem que ser menor ou igual a taxaFreteFinal
//		Predicate taxaFinalPredicate = builder.lessThanOrEqualTo(root.get("taxaFrete"), taxaFreteFinal);
//		
//		criteria.where(nomePredicate, taxaInicialPredicate, taxaFinalPredicate);
//		
//		TypedQuery<Restaurante> query = manager.createQuery(criteria);
//		
//		return query.getResultList();
//	}
	
	
	/*
	 * Consulta com criteria e filtros dinamicos
	 */
	@Override
	public List<Restaurante> find(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal){
		
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		
		CriteriaQuery<Restaurante> criteria = builder.createQuery(Restaurante.class);
		Root<Restaurante> root = criteria.from(Restaurante.class);
		
		var predicates = new ArrayList<Predicate>();
		
		if(StringUtils.hasText(nome)) { // Se o nome não esta vazio nem nulo
			predicates.add(builder.like(root.get("nome"), "%" + nome + "%"));
		}
		if(taxaFreteInicial != null) {
			// greaterThanOrEqualTo -> taxaFrete tem que ser maior ou igual a taxaFreteInicial
			predicates.add(builder.greaterThanOrEqualTo(root.get("taxaFrete"), taxaFreteInicial));
		}
		if(taxaFreteFinal != null) {
			// lessThanOrEqualTo -> taxaFrete tem que ser menor ou igual a taxaFreteFinal
			predicates.add(builder.lessThanOrEqualTo(root.get("taxaFrete"), taxaFreteFinal));
		}
		// convertendo uma List em um arry com toArray()
		criteria.where(predicates.toArray(new Predicate[0]));
		
		TypedQuery<Restaurante> query = manager.createQuery(criteria);
		
		return query.getResultList();
	}


	@Override
	public List<Restaurante> findComFreteGratis(String nome) {
		
		return repository.findAll(RestauranteSpecs.comFreteGratis()
				.and(RestauranteSpecs.comNomeSemelhante(nome)));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
