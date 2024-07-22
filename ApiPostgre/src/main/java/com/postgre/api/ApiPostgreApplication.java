package com.postgre.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class ApiPostgreApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiPostgreApplication.class, args);
	}

}
