package br.com.wepdev.notificacao;

import org.springframework.stereotype.Component;

import br.com.wepdev.modelo.Cliente;

@Component // Definindo a classe como um Bean spring, o spring gerencia, instancia , configura e injeta objetos dessa classe em outros beans
public class NotificadorEmail implements Notificador {
	

	/*
	 * Dessa forma se testa o bean, o resultado aparece no console
	 */
	public NotificadorEmail() {
		System.out.println("NotificadorEmail");
	}
	
	@Override
	public void notificar(Cliente cliente, String mensagem) {
		System.out.printf("Notificando %s atrav�s do e-mail %s: %s\n", 
				cliente.getNome(), 
				cliente.getEmail(), 
				mensagem);
		
	}

}
