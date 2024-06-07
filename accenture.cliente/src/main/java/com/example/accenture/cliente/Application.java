package com.example.accenture.cliente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		HelloClient client = new HelloClient("localhost", 8090);
		client.greet("World");
	}

}
