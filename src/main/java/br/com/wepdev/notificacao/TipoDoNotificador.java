package br.com.wepdev.notificacao;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.springframework.beans.factory.annotation.Qualifier;

@Retention(RetentionPolicy.RUNTIME) // tempo que essa anotação funcionara, em tempo de execução
@Qualifier // Essa anotação e um qualificador
public @interface TipoDoNotificador {
	
	NivelUrgencia value();

}
