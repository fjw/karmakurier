package com.coronakarma.backend;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class CoronaKarmaBackendApplication {

	public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(CoronaKarmaBackendApplication.class, args);
	}

}
