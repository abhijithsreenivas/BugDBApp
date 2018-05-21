package com.abhijith.restapp.bugdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan("com.abhijith.restapp")
@SpringBootApplication
public class BugdbApplication {

	public static void main(String[] args) {
		SpringApplication.run(BugdbApplication.class, args);
	}
}
