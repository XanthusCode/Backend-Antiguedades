package com.example;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;


@SpringBootApplication
@PropertySource("classpath:messages.properties")
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

}