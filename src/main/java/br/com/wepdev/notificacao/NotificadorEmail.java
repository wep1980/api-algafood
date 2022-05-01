package br.com.wepdev.notificacao;

import br.com.wepdev.modelo.Cliente;

//@Component ao retirar o @Component e necessario dizer para o spring a nova forma de instanciar essa classe
public class NotificadorEmail implements Notificador {
	
	private boolean caixaAlta;// por padrão aqui ja é false
	private String hostServidorSmtp; // servidor de email

	/*
	 * Com esse construtor se testa o bean, o resultado aparece no console
	 * receber o servidor smtp como parametro
	 */
	public NotificadorEmail(String hostServidorSmtp) {
		this.hostServidorSmtp = hostServidorSmtp;
		System.out.println("NotificadorEmail");
	}
	
	@Override
	public void notificar(Cliente cliente, String mensagem) {
		
		if(this.caixaAlta) { // se caixa alta for true
			mensagem = mensagem.toUpperCase(); // transforma toda mensagem em letra maiuscula.
		}
		System.out.printf("Notificando %s atrav�s do e-mail %s usando SMTP %s: %s\n", 
				cliente.getNome(), 
				cliente.getEmail(), 
				this.hostServidorSmtp,
				mensagem);
	}
	
	
	public void setCaixaAlta(boolean caixaAlta) {
		this.caixaAlta = caixaAlta;
	}

}
