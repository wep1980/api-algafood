package br.com.wepdev.notificacao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import br.com.wepdev.modelo.Cliente;

//@Qualifier("normal") // Qualificando esse componente
@Profile("prod") // Esse componente vai ser registrado no spring apenas se o projeto estiver rodando no ambiente de produção
@TipoDoNotificador(NivelUrgencia.SEM_URGENCIA) // Anotação customizada
@Component
public class NotificadorEmail implements Notificador {
	
	
	// com esse construtor eu consigo testar o ambiente que esta funcionando
	public NotificadorEmail() {
		System.out.println("Notificador de email real - AMBIENTE DE PRODUÇÃO");
	}

	@Override
	public void notificar(Cliente cliente, String mensagem) {
	
		System.out.printf("Notificando %s atrav�s do e-mail %s: %s\n", 
				cliente.getNome(), 
				cliente.getEmail(), 
				mensagem);
	}


}
