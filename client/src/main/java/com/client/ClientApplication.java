package com.client;

import com.client.auth.Dao.RoleDao;
import com.client.auth.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.client")
public class ClientApplication extends SpringBootServletInitializer implements CommandLineRunner {
	@Autowired
	private RoleDao roleRepository;

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(WebApplicationType.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if (roleRepository.findByName("EMPLOYE") ==null) {
			roleRepository.save(new Role("EMPLOYE"));
		}
		if (roleRepository.findByName("CHEF") ==null) {
			roleRepository.save(new Role("CHEF"));
		}
		if (roleRepository.findByName("ADMIN") ==null) {
			roleRepository.save(new Role("ADMIN"));
		}
	}
}
