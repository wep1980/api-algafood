package br.com.wepdev.notificacao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import br.com.wepdev.modelo.Cliente;

@Qualifier("normal") // Qualificando esse componente
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
