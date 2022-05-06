package com.example.licenta;

import com.example.licenta.entity.AppUser;
import com.example.licenta.entity.Role;
import com.example.licenta.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class LicentaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LicentaApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserService userService){
		return args -> {
			userService.saveRole(new Role(null, "USER"));
			userService.saveRole(new Role(null, "ADMIN"));

			userService.saveUser(new AppUser(null, "Goia Catalin", "goia", "1234", new ArrayList<>()));
			userService.saveUser(new AppUser(null, "ALA BALA", "alabala", "1234", new ArrayList<>()));

			userService.addRoleToUser("goia", "USER");
			userService.addRoleToUser("goia", "ADMIN");
			userService.addRoleToUser("alabala", "USER");

		};
	}

}
