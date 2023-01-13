package br.com.wepdev.domain.repository;

import java.util.List;

import br.com.wepdev.domain.model.Cozinha;

public interface CozinhaRepository {
	
	
	List<Cozinha> listar();
	Cozinha porId(Long id);
	Cozinha salvar(Cozinha cozinha);
	void remover(Cozinha cozinha);

}
