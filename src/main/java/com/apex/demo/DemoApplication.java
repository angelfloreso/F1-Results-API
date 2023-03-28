package com.apex.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
@EnableSwagger2
@EnableAutoConfiguration
@ComponentScan
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	private SecurityContext securityContext() {
		return SecurityContext.builder().securityReferences(defaultAuth()).build();
	}

	private List<SecurityReference> defaultAuth() {
		AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		authorizationScopes[0] = authorizationScope;
		return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
	}
	private ApiKey apiKey() {
		return new ApiKey("JWT", "Authorization", "header");
	}
	private ApiInfo apiInfo() {
		return new ApiInfo(
				"F1 Results API",
				"This is an API for request the last results and statistics of F1",
				"1.0",
				"https://raw.githubusercontent.com/afv9988/F1-Results-API/main/src/main/resources/TNC.txt",
				new Contact("Angel Flores", "https://www.linkedin.com/in/angel-flores-olivas/", "afv9988@gmail.com"),
				"License of API",
				"https://raw.githubusercontent.com/afv9988/F1-Results-API/main/src/main/resources/TNC.txt",
				Collections.emptyList());
	}
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.host("afdev.ddns.net")//must be declared
				.apiInfo(apiInfo())
				.securityContexts(Arrays.asList(securityContext()))
				.securitySchemes(Arrays.asList(apiKey()))
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.apex.demo.controller")).build()
				;
	}
}
