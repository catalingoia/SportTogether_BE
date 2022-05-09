package com.example.licenta;

import com.example.licenta.DTOs.AppUserRequestDTO;
import com.example.licenta.entity.AppUser;
import com.example.licenta.entity.Role;
import com.example.licenta.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class LicentaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LicentaApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService){
		return args -> {
			userService.saveRole(new Role(null, "USER"));
			userService.saveRole(new Role(null, "ADMIN"));

			userService.saveUser(new AppUserRequestDTO("Goia Catalin", "goia", "1234"));
			userService.saveUser(new AppUserRequestDTO("ALA BALA", "alabala", "1234"));

			userService.addRoleToUser("goia", "USER");
			userService.addRoleToUser("goia", "ADMIN");
			userService.addRoleToUser("alabala", "USER");

		};
	}

}
