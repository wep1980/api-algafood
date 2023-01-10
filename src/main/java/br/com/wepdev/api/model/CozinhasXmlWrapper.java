package br.com.wepdev.api.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import br.com.wepdev.domain.model.Cozinha;
import lombok.Data;
import lombok.NonNull;

// Classe criada para correção dos nomes dos campos na serialização em XML
@Data
@JacksonXmlRootElement(localName = "cozinhas")
public class CozinhasXmlWrapper {

	/* Anotacao do lombok, o @Data gera construtores quando existe pelo ao menos uma propriedade obrigatoria
	e a anotação @NonNull torna a propriedade obrigatoria*/
	@NonNull
	@JsonProperty("cozinha")
	@JacksonXmlElementWrapper(useWrapping = false) // desabilita um embrulho (cozinhas) que tem a mais na serialização
	private List<Cozinha> cozinhas;
}
