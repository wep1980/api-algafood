package br.com.wepdev.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.wepdev.api.model.CozinhasXmlWrapper;
import br.com.wepdev.domain.model.Cozinha;
import br.com.wepdev.domain.repository.CozinhaRepository;

@RestController
@RequestMapping(value = "/cozinhas") 
public class CozinhaController {
	
	
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})//, MediaType.APPLICATION_XML_VALUE})
	public List<Cozinha> listar(){
		return cozinhaRepository.listar();
	}
	
	@GetMapping(produces = {MediaType.APPLICATION_XML_VALUE})
	public CozinhasXmlWrapper listarXml(){
		return new CozinhasXmlWrapper(cozinhaRepository.listar());
	}
	
	@GetMapping(value = "/{cozinhaId}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Cozinha buscar(@PathVariable("cozinhaId") Long id) {
		return cozinhaRepository.porId(id);
	}

}
