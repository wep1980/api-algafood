package br.com.wepdev;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PrimeiroController {
	
	
	@GetMapping("/teste")
	@ResponseBody
	public String testeController() {
		return "Teste do controller funcionando com sucesso!!";
	}

}
