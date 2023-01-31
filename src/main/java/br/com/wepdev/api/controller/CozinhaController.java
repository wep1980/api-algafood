package br.com.wepdev.api.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.wepdev.api.model.CozinhasXmlWrapper;
import br.com.wepdev.domain.exception.EntidadeEmUsoException;
import br.com.wepdev.domain.exception.EntidadeNaoEncontradaException;
import br.com.wepdev.domain.model.Cozinha;
import br.com.wepdev.domain.repository.CozinhaRepository;
import br.com.wepdev.domain.service.CozinhaService;

@RestController
@RequestMapping(value = "/cozinhas")
public class CozinhaController {

	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	@Autowired
	private CozinhaService cozinhaService;
	
	

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE }) // , MediaType.APPLICATION_XML_VALUE})
	public List<Cozinha> listar() {
		return cozinhaRepository.listar();
	}

	@GetMapping(produces = { MediaType.APPLICATION_XML_VALUE })
	public CozinhasXmlWrapper listarXml() {
		return new CozinhasXmlWrapper(cozinhaRepository.listar());
	}

	@ResponseStatus(HttpStatus.OK) // forma mais generica de enviar um status
	@GetMapping("/{cozinhaId}")
	public ResponseEntity<Cozinha> buscar(@PathVariable("cozinhaId") Long id) {

		Cozinha cozinha = cozinhaRepository.buscar(id);

		if (cozinha != null) {
			return ResponseEntity.ok(cozinha);
		}
		return ResponseEntity.notFound().build();
	}

	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public Cozinha adicionar(@RequestBody Cozinha cozinha) {
		return cozinhaService.salvarOuAtualizar(cozinha);
	}

	
	@PutMapping("/{cozinhaId}")
	public ResponseEntity<Cozinha> atualizar(@PathVariable Long cozinhaId, @RequestBody Cozinha cozinha) {

		Cozinha cozinhaAtual = cozinhaRepository.buscar(cozinhaId);

		if (cozinhaAtual != null) {
			// cozinhaAtual.setNome(cozinha.getNome());
			BeanUtils.copyProperties(cozinha, cozinhaAtual, "id"); // O ID de cozinha que é nulo, não sera copiado para
																	// a cozinha atual
			cozinhaRepository.salvarOuAtualizar(cozinhaAtual);

			return ResponseEntity.ok(cozinhaAtual);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{cozinhaId}")
	public ResponseEntity<Cozinha> remover(@PathVariable Long cozinhaId){
		try {
			cozinhaService.excluir(cozinhaId);
			return ResponseEntity.noContent().build();
			
		} catch (EntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.notFound().build();
		}

	}

}
