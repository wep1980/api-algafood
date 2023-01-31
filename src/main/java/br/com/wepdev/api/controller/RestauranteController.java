package br.com.wepdev.api.controller;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.wepdev.domain.exception.EntidadeNaoEncontradaException;
import br.com.wepdev.domain.model.Restaurante;
import br.com.wepdev.domain.repository.RestauranteRepository;
import br.com.wepdev.domain.service.RestauranteService;

@RestController
@RequestMapping(value = "/restaurantes")
public class RestauranteController {

	@Autowired
	private RestauranteService restauranteService;
	
	@Autowired
	private RestauranteRepository restauranteRepository;
	
	
	  @GetMapping
		public List<Restaurante> listar() {
			return restauranteService.listar();
		}
	  
	  
		@ResponseStatus(HttpStatus.OK) // forma mais generica de enviar um status
		@GetMapping("/{restauranteId}")
		public ResponseEntity<Restaurante> buscar(@PathVariable("restauranteId") Long id) {

			Restaurante restaurante = restauranteRepository.buscar(id);

			if (restaurante != null) {
				return ResponseEntity.ok(restaurante);
			}
			return ResponseEntity.notFound().build();
		}
		
		
		//@ResponseStatus(HttpStatus.CREATED)
		@PostMapping
		public ResponseEntity<?> adicionar (@RequestBody Restaurante restaurante){
			try {
				restaurante = restauranteService.salvar(restaurante);
				
				return ResponseEntity.status(HttpStatus.CREATED).body(restaurante);
			} catch (EntidadeNaoEncontradaException e) {
				
				return ResponseEntity.badRequest().body(e.getMessage());
			}
			
		}
		
		
	    @PutMapping("/{restauranteId}")
	    public ResponseEntity<?> atualizar(@PathVariable Long restauranteId,
	        @RequestBody Restaurante restaurante) {
	        try {
				Restaurante restauranteAtual = restauranteRepository.buscar(restauranteId);
				
				if (restauranteAtual != null) {
					BeanUtils.copyProperties(restaurante, restauranteAtual, "id");
					
					restauranteAtual = restauranteService.salvar(restauranteAtual);
					return ResponseEntity.ok(restauranteAtual);
				}
				return ResponseEntity.notFound().build();
			
			} catch (EntidadeNaoEncontradaException e) {
				return ResponseEntity.badRequest().body(e.getMessage());
			}
	    }
		
		
	    @PatchMapping("/{restauranteId}")
		public ResponseEntity<?> atualizarParcial(@PathVariable Long restauranteId, @RequestBody Map<String, Object> campos){
			
	    	Restaurante restauranteAtual = restauranteRepository.buscar(restauranteId);
	    	if(restauranteAtual == null) {
	    		return ResponseEntity.notFound().build();
	    	}
	    	merge(campos, restauranteAtual);
	    	
			return atualizar(restauranteId, restauranteAtual);
		}


		private void merge(Map<String, Object> dadosOrigem, Restaurante restauranteDestino) {
			
			// Resposavel por serializar(converter) objetos java em json e vice e versa
			ObjectMapper objectMapper = new ObjectMapper();
			//Convertendo as propriedades de origem em tipo Restaurante
			Restaurante restauranteOrigem = objectMapper.convertValue(dadosOrigem, Restaurante.class);
			
			System.out.println(restauranteOrigem);
					
			dadosOrigem.forEach((nomePropriedade, valorPropriedade) -> {
				
				Field field = ReflectionUtils.findField(Restaurante.class, nomePropriedade);
				field.setAccessible(true); // Tornando acessivel a variavel do objeto que é privada
				
				Object novoValor = ReflectionUtils.getField(field, restauranteOrigem);
				System.out.println(nomePropriedade + " = " + valorPropriedade + " = " + novoValor);
				
	    		ReflectionUtils.setField(field, restauranteDestino, novoValor);
	    	});
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
