package br.com.wepdev.notificacao;

import br.com.wepdev.modelo.Cliente;

public interface Notificador {

	void notificar(Cliente cliente, String mensagem);

}