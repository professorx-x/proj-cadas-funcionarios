package com.universconsole.cadastro_funcionarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EntityScan(basePackages = {"com.universconsole.cadastro_funcionarios"})
@ComponentScan(basePackages = {"com.*"})
public class CadastroFuncionariosApplication {

	public static void main(String[] args) {
		SpringApplication.run(CadastroFuncionariosApplication.class, args);
	}

}
