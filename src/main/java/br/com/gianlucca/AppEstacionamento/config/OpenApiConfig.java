package br.com.gianlucca.AppEstacionamento.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class OpenApiConfig {

	@Bean
	public OpenAPI customerOpenAPI() {
		return new OpenAPI()
				.components(new Components().addSecuritySchemes("basicScheme",
						new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("basic")))
						.info(new Info()
								.title("App Coontrole de estacionamento")
								.description("Este aplicativo faz controle de cadastro de estacionamento")
								.contact(new Contact().name("Gianlucca").email("gianluccagostini977@gmail.com").url("url"))
								.version("Versão 0.0.1-SNAPSHOT"));
	}
}
