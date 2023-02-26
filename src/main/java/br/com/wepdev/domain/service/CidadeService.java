package br.com.wepdev.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.wepdev.domain.exception.EntidadeEmUsoException;
import br.com.wepdev.domain.exception.EntidadeNaoEncontradaException;
import br.com.wepdev.domain.model.Cidade;
import br.com.wepdev.domain.model.Estado;
import br.com.wepdev.domain.repository.CidadeRepository;
import br.com.wepdev.domain.repository.EstadoRepository;

@Service
public class CidadeService {

	
	@Autowired
    private CidadeRepository cidadeRepository;
    
	@Autowired
    private EstadoRepository estadoRepository;
    
	
	
	public Cidade salvar(Cidade cidade) {
		
        Long estadoId = cidade.getEstado().getId();
        
        Estado estado = estadoRepository.findById(estadoId)
        		.orElseThrow(() -> new EntidadeNaoEncontradaException(
        		    String.format("Não existe cadastro de estado com código %d", estadoId)));
        
        cidade.setEstado(estado);
        
        return cidadeRepository.save(cidade);
    }
    
    
    @GetMapping("/{cidadeId}")
	public ResponseEntity<Cidade> buscar(@PathVariable Long cidadeId) {
		Optional<Cidade> cidade = cidadeRepository.findById(cidadeId);
		
		if (cidade.isPresent()) {
			return ResponseEntity.ok(cidade.get());
		}
		return ResponseEntity.notFound().build();
	}
    
    
	public void excluir(Long cidadeId) {
		try {
			cidadeRepository.deleteById(cidadeId);
			
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
				String.format("Não existe um cadastro de cidade com código %d", cidadeId));
		
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
				String.format("Cidade de código %d não pode ser removida, pois está em uso", cidadeId));
		}
	}
    
}
