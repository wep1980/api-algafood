package br.com.wepdev.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.wepdev.domain.exception.EntidadeNaoEncontradaException;
import br.com.wepdev.domain.model.Cozinha;
import br.com.wepdev.domain.model.Restaurante;
import br.com.wepdev.domain.repository.CozinhaRepository;
import br.com.wepdev.domain.repository.RestauranteRepository;

@Service
public class RestauranteService {
	
	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	
	public Restaurante salvar(Restaurante restaurante) {
		
		Long cozinhaId = restaurante.getCozinha().getId();
		Cozinha cozinha = cozinhaRepository.buscar(cozinhaId);
		
		if(cozinha == null) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe cadastro de cozinha com o código %d", cozinhaId));
		}
		restaurante.setCozinha(cozinha);
		
		return restauranteRepository.salvar(restaurante);
	}
	
	
	public Restaurante buscar(Long restauranteId) {

		Restaurante restaurante = restauranteRepository.buscar(restauranteId);

		if (restaurante != null) {
			return restaurante;
		}
	    return null;
	}
	
	
	public List<Restaurante> listar() {
		return restauranteRepository.listar();
	}
	
	
//	public void excluir (Long restauranteId) {
//		try {
//			restauranteRepository.remover(restauranteId);
//			     /*
//			      * DataIntegrityViolationException - essa exception ocorre ao tentar deletar uma cozinha que esteja associada a um restaurante,
//			      * como e uma exception de infra estrutura ela sera tratada e traduzida aqui, por uma exception customizada
//			      */
//		} catch (DataIntegrityViolationException e) { 
//			throw new EntidadeEmUsoException(String.format("Restaurante de codigo %d não pode ser removido, pois esta em uso", cozinhaId));
//			
//		} catch (EmptyResultDataAccessException e) {
//			throw new EntidadeNaoEncontradaException(String.format("Não existe um cadastro de cozinha com código %d", cozinhaId));
//		}
//	}

}
