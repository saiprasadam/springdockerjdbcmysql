package com.poc.demo.jdbc.Springbootjdbc;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerSpringJdbc {
	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("")
				.apiInfo(metaData()).select().paths(postPaths()).build();
	}

	private Predicate<String> postPaths() {

		return or(regex("/api/posts.*"), regex("/orgdetailjdbc/.*"));

	}

	
	  private ApiInfo metaData() {
	        ApiInfo apiInfo = new ApiInfo(
	        		"Spring Boot Rest API ",
	                " Organizations Details",
	                "1.0",
	                "Terms of service",
	                 new Contact("Saiprasad", "https://springframework.orgInfo/about/", "organizationInfoDetail"),
	               "Apache License Version 2.0",
	                "https://www.apache.org/licenses/LICENSE-2.0");
	        return apiInfo;
	    }
}
