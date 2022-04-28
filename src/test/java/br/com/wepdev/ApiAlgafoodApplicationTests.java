package br.com.wepdev;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class) // Adicionada essa anotação para que não ocorra erros relacionado ao pacote do Junit
@SpringBootTest
class ApiAlgafoodApplicationTests {

	
	@Test
	void contextLoads() {
	}

}
