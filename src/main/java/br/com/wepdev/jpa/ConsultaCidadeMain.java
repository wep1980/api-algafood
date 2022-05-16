package br.com.wepdev.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import br.com.wepdev.domain.model.Cidade;
import br.com.wepdev.domain.repository.CidadeRepository;
import br.com.wepdev.ApiAlgafoodApplication;

public class ConsultaCidadeMain {

	
	public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(ApiAlgafoodApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);
        
        CidadeRepository cidadeRepository = applicationContext.getBean(CidadeRepository.class);
        
        List<Cidade> todasCidades = cidadeRepository.listar();
        
        for (Cidade cidade : todasCidades) {
            System.out.printf("%s - %s\n", cidade.getNome(), cidade.getEstado().getNome());
        }
    }
}
