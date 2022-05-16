package br.com.wepdev.domain.repository;

import java.util.List;

import br.com.wepdev.domain.model.Restaurante;

public interface RestauranteRepository {
	
	
	List<Restaurante> listar();
	Restaurante buscar(Long id);
	Restaurante salvar(Restaurante restaurante);
	void remover(Restaurante restaurante);

}
