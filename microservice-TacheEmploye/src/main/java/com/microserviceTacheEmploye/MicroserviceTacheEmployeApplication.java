package com.microserviceTacheEmploye;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.microserviceTacheEmploye")
public class MicroserviceTacheEmployeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceTacheEmployeApplication.class, args);
	}

}
