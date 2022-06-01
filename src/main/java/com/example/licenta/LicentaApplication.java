package com.example.licenta;

import com.example.licenta.DTOs.AppUserRequestDTO;
import com.example.licenta.DTOs.EventRequestDTO;
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
			userService.saveUser(new AppUserRequestDTO("Dar", "Da", "1234", "dada@yahoo.com"));

			userService.saveUser(new AppUserRequestDTO("ALA","BALA", "1234", "alabala"));

			userService.addRoleToUser("goia", "USER");
			userService.addRoleToUser("goia", "ADMIN");
			userService.addRoleToUser("alabala", "USER");
			userService.addRoleToUser("dada@yahoo.com", "USER");

			eventService.createEvent(new EventRequestDTO("AAA", "amator", "0743533431","cata@yahoo.com", 12, 11,
			"Va astept in numar cat mai mare aici","May 21 2000","12:00 AM","Cluj arena"), "goia");
			eventService.createEvent(new EventRequestDTO("BBB", "amator", "0743533431","cata@yahoo.com", 12, 11,
					"Va astept in numar cat mai mare aici","May 21 2000","12:00 AM","Cluj arena"), "goia");
			eventService.createEvent(new EventRequestDTO("CCC", "amator", "0743533431","cata@yahoo.com", 12, 11,
					"Va astept in numar cat mai mare aici","May 21 2000","12:00 AM","Cluj arena"), "goia");
			eventService.createEvent(new EventRequestDTO("DDD", "amator", "0743533431","cata@yahoo.com", 12, 11,
					"Va astept in numar cat mai mare aici","May 21 2000","12:00 AM","Cluj arena"), "goia");
			eventService.createEvent(new EventRequestDTO("EEE", "amator", "0743533431","cata@yahoo.com", 12, 11,
					"Va astept in numar cat mai mare aici","May 21 2000","12:00 AM","Cluj arena"), "goia");
			eventService.createEvent(new EventRequestDTO("FFF", "amator", "0743533431","cata@yahoo.com", 12, 11,
					"Va astept in numar cat mai mare aici","May 21 2000","12:00 AM","Cluj arena"), "goia");
			eventService.createEvent(new EventRequestDTO("GGG", "amator", "0743533431","cata@yahoo.com", 12, 11,
					"Va astept in numar cat mai mare aici","May 21 2000","12:00 AM","Cluj arena"), "goia");
			eventService.createEvent(new EventRequestDTO("HHH", "amator", "0743533431","cata@yahoo.com", 12, 11,
					"Va astept in numar cat mai mare aici","May 21 2000","12:00 AM","Cluj arena"), "goia");


		};
	}

}
