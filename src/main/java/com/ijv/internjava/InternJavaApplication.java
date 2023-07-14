package com.ijv.internjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("com.ijv.internjava.model.entity")
@EnableJpaRepositories("com.ijv.internjava.repository")
@SpringBootApplication
public class InternJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(InternJavaApplication.class, args);
	}

}
