package com.viceri.api.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.viceri.api.controllers")).paths(PathSelectors.any())
				.build().apiInfo(apiInfo()).pathMapping("/");
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("TO-DO",
				"Aplicação backend de teste em java spring, usando: Lombok, servidor H2 e documentação Swagger.",
				"1.0.0v", null, new Contact("Adrina Mirian Mendes Cardoso", "", "adrianamirianmc@gmail.com"),
				"Apache 2.0", "https://www.apache.org/licenses/LICENSE-2.0", Collections.emptyList());
	}
}