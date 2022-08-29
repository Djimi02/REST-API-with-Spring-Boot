package com.example.jobappwithdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@SpringBootApplication
public class JobappwithdbApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobappwithdbApplication.class, args);
	}

}
