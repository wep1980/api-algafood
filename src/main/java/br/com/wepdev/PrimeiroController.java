package br.com.wepdev;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.wepdev.modelo.Cliente;
import br.com.wepdev.service.AtivacaoClienteService;

@Controller // E um bean tambem, somente possui uma semantica diferente. componente gerenciado pelo spring
public class PrimeiroController {
	
	private AtivacaoClienteService ativacaoClienteService;
	
	
	
	public PrimeiroController(AtivacaoClienteService ativacaoClienteService) {
		this.ativacaoClienteService = ativacaoClienteService;
		
		System.out.println("PrimeiroController" + ativacaoClienteService);
	}



	@GetMapping("/teste")
	@ResponseBody
	public String testeController() {
		
		Cliente cliente1 = new Cliente("João", "jo@gmail.com", "21 22552494");
		ativacaoClienteService.ativar(cliente1);
		
		return "Teste do controller funcionando com sucesso!!";
	}

}
