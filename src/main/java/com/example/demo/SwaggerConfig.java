package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket enab() {
		Docket docket = new Docket(DocumentationType.SWAGGER_2);
		ApiSelectorBuilder select = docket.select();
		ApiSelectorBuilder apis = select.apis(RequestHandlerSelectors.basePackage("com.example.demo"));
		ApiSelectorBuilder paths = apis.paths(PathSelectors.any());
		Docket build = paths.build();
		return build;

	}
}
