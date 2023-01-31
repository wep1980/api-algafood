package br.com.wepdev.api.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.wepdev.domain.exception.EntidadeEmUsoException;
import br.com.wepdev.domain.exception.EntidadeNaoEncontradaException;
import br.com.wepdev.domain.model.Cidade;
import br.com.wepdev.domain.repository.CidadeRepository;
import br.com.wepdev.domain.service.CidadeService;

@RestController
@RequestMapping(value = "/cidades")
public class CidadeController {

	
	@Autowired
	private CidadeService cidadeService;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	
    @GetMapping("/{cidadeId}")
	public ResponseEntity<Cidade> buscar(@PathVariable Long cidadeId) {
		Cidade cidade = cidadeRepository.buscar(cidadeId);
		
		if (cidade != null) {
			return ResponseEntity.ok(cidade);
		}
		
		return ResponseEntity.notFound().build();
	}
    
    
    @PostMapping
	public ResponseEntity<?> adicionar(@RequestBody Cidade cidade) {
		try {
			cidade = cidadeService.adicionar(cidade);
			
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(cidade);
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.badRequest()
					.body(e.getMessage());
		}
	}
    
    
    @PutMapping("/{cidadeId}")
	public ResponseEntity<Cidade> atualizar(@PathVariable Long cidadeId, @RequestBody Cidade cidade) {
    	
		Cidade cidadeAtual = cidadeRepository.buscar(cidadeId);
		
		if (cidadeAtual != null) {
			BeanUtils.copyProperties(cidade, cidadeAtual, "id");
			
			cidadeAtual = cidadeService.adicionar(cidadeAtual);
			return ResponseEntity.ok(cidadeAtual);
		}
		
		return ResponseEntity.notFound().build();
	}
    
    
    @DeleteMapping("/{cidadeAId}")
	public ResponseEntity<?> remover(@PathVariable Long cidadeAId) {
		try {
			cidadeService.excluir(cidadeAId);	
			return ResponseEntity.noContent().build();
			
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.notFound().build();
			
		} catch (EntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT)
					.body(e.getMessage());
		}
	}
}
