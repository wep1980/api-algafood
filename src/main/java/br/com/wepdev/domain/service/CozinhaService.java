package br.com.wepdev.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.wepdev.domain.exception.EntidadeEmUsoException;
import br.com.wepdev.domain.exception.EntidadeNaoEncontradaException;
import br.com.wepdev.domain.model.Cozinha;
import br.com.wepdev.domain.repository.CozinhaRepository;

@Service
public class CozinhaService {
	
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	
	public Cozinha salvarOuAtualizar(Cozinha cozinha) {
		return cozinhaRepository.save(cozinha);
	}
	
	public void excluir (Long cozinhaId) {
		try {
			cozinhaRepository.deleteById(cozinhaId);
			     /*
			      * DataIntegrityViolationException - essa exception ocorre ao tentar deletar uma cozinha que esteja associada a um restaurante,
			      * como e uma exception de infra estrutura ela sera tratada e traduzida aqui, por uma exception customizada
			      */
		} catch (DataIntegrityViolationException e) { 
			throw new EntidadeEmUsoException(String.format("Cozinha de codigo %d não pode ser removida, pois esta em uso", cozinhaId));
			
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(String.format("Não existe um cadastro de cozinha com código %d", cozinhaId));
		}
	}

}
