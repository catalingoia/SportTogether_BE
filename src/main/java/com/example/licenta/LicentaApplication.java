package com.example.licenta;

import com.example.licenta.DTOs.AppUserRequestDTO;
import com.example.licenta.DTOs.EventRequestDTO;
import com.example.licenta.entity.AppUser;
import com.example.licenta.entity.Role;
import com.example.licenta.service.EventService;
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
	CommandLineRunner run(UserService userService, EventService eventService){
		return args -> {
			userService.saveRole(new Role(null, "USER"));
			userService.saveRole(new Role(null, "ADMIN"));

			userService.saveUser(new AppUserRequestDTO("Goia", "Catalin", "1234", "goia"));
			userService.saveUser(new AppUserRequestDTO("ALA","BALA", "1234", "alabala"));

			userService.addRoleToUser("goia", "USER");
			userService.addRoleToUser("goia", "ADMIN");
			userService.addRoleToUser("alabala", "USER");

			eventService.createEvent(new EventRequestDTO("Fotbal", "amator", "cluj arena", 12.00, 11), "goia");
			eventService.createEvent(new EventRequestDTO("Baschet", "profesionist", "gheorgheni", 12.00, 5), "alabala");
			eventService.createEvent(new EventRequestDTO("Ping pong", "amator", "baza unirea", 32.00, 2), "alabala");
			eventService.createEvent(new EventRequestDTO("Baschet", "profesionist", "cluj arena", 0.00, 21), "goia");
			eventService.createEvent(new EventRequestDTO("Tenis", "amator", "acasa la mine", 12.00, 11), "goia");
			eventService.createEvent(new EventRequestDTO("Volei", "amator", "cluj arena", 12.00, 11), "goia");
			eventService.createEvent(new EventRequestDTO("Volei", "amator", "cluj arena", 12.00, 11), "goia");


		};
	}

}
