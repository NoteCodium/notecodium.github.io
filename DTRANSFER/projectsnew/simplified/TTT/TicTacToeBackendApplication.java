package com.example.TicTacToeBackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class TicTacToeBackendApplication extends SpringBootServletInitializer {

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(TicTacToeBackendApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(TicTacToeBackendApplication.class, args);
	}

}
