package br.com.wepdev.notificacao;

import org.springframework.stereotype.Component;

import br.com.wepdev.modelo.Cliente;

@Component
public class NotificadorEmail implements Notificador {
	

	@Override
	public void notificar(Cliente cliente, String mensagem) {
	
		System.out.printf("Notificando %s atrav�s do e-mail %s: %s\n", 
				cliente.getNome(), 
				cliente.getEmail(), 
				mensagem);
	}


}
