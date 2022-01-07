package com.stone.will.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class PasswordVaultApplication {

	public static void main(String[] args) {
		SpringApplication.run(PasswordVaultApplication.class, args);
	}

}
