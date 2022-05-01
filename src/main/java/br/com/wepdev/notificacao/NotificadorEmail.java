package br.com.wepdev.notificacao;

import org.springframework.stereotype.Component;

import br.com.wepdev.modelo.Cliente;

@Component // Definindo a classe como um Bean spring, o spring gerencia, instancia , configura e injeta objetos dessa classe em outros beans
public class NotificadorEmail {
	

//	/*
//	 * Dessa forma se testa o bean, o resultado aparece no console
//	 */
//	public NotificadorEmail() {
//		System.out.println("Construtor chamado");
//	}
	
	public void notificar(Cliente cliente, String mensagem) {
		System.out.printf("Notificando %s atrav�s do e-mail %s: %s\n", 
				cliente.getNome(), 
				cliente.getEmail(), 
				mensagem);
		
	}

}
