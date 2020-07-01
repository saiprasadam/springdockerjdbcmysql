package com.poc.demo.jdbc.Springbootjdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * Hello world!
 *
 */
	@SpringBootApplication
	@EnableAutoConfiguration
	@Import(SwaggerSpringJdbc.class)
	public class Application 
{

    public static void main( String[] args )
    {
    	
       SpringApplication.run(Application.class, args);
    }
}
