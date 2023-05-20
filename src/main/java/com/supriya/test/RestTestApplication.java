package com.supriya.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class RestTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestTestApplication.class, args);
	}
	
	
	

}
