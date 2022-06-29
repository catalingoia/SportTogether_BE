package com.example.licenta;

import com.example.licenta.DTOs.AppUserRequestDTO;
import com.example.licenta.DTOs.EventRequestDTO;
import com.example.licenta.model.Role;
import com.example.licenta.service.EventService;
import com.example.licenta.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

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

			userService.saveUser(new AppUserRequestDTO("Goia", "Catalin", "1234", "catalin.goia1@gmail.com", "0743530034"));
			userService.saveUser(new AppUserRequestDTO("Dumitru", "Sonia", "1234", "sonia@yahoo.com", "0743233434"));
			userService.saveUser(new AppUserRequestDTO("Ursu", "Sergiu", "1234", "ursu@yahoo.com", "0743444555"));
			userService.saveUser(new AppUserRequestDTO("Moldovean", "Camelia", "1234", "moldo@gmail.com", "0743643312"));
			userService.saveUser(new AppUserRequestDTO("Dragomir","Alexandru", "1234", "dragomir@gmail.com", "0745543343"));

			userService.addRoleToUser("catalin.goia1@gmail.com", "USER");
			userService.addRoleToUser("catalin.goia1@gmail.com", "ADMIN");
			userService.addRoleToUser("sonia@yahoo.com", "USER");
			userService.addRoleToUser("ursu@yahoo.com", "USER");
			userService.addRoleToUser("moldo@gmail.com", "USER");
			userService.addRoleToUser("dragomir@gmail.com", "USER");

			eventService.createEvent(new EventRequestDTO("Football", "Amateur", "0744393666","sonia@yahoo.com", 11, 12,
			"Va astept in numar cat mai mare","Jun 10 2022","1:00 PM","Baza sportivă Unirea"), "sonia@yahoo.com");
			eventService.createEvent(new EventRequestDTO("Basketball", "Amateur", "0722334547","sonia@yahoo.com", 9, 0,
					"Va astept in numar cat mai mare","Jun 11 2022","2:00 PM","Parcul Rozelor"), "sonia@yahoo.com");
			eventService.createEvent(new EventRequestDTO("Handball", "First time", "0745037061","sonia@yahoo.com", 11, 10,
					"Va astept in numar cat mai mare","Jul 2 2022","11:00 AM","Parcul Babeș-Bolyai"), "sonia@yahoo.com");
			eventService.createEvent(new EventRequestDTO("Rugby", "Professional", "0730071203","ursu@yahoo.com", 29, 0,
					"Va astept in numar cat mai mare","Jul 5 2022","10:00 AM","Parcul Babeș-Bolyai"), "sonia@yahoo.com");
			eventService.createEvent(new EventRequestDTO("Tennis", "Intermediate", "0722213210","sonia@yahoo.com", 1, 20,
					"Am nevoie de un partener pentru un meci de Tenis. Trebuie sa ai racheta proprie","May 21 2022","6:00 PM","Baza sportivă Unirea"), "ursu@yahoo.com");
			eventService.createEvent(new EventRequestDTO("Football", "Intermediate", "0722640270","ursu@yahoo.com", 21, 13,
					"Va astept in numar cat mai mare","Jul 24 2022","6:00 PM","Baza sportivă Gheorgheni"), "ursu@yahoo.com");
			eventService.createEvent(new EventRequestDTO("Football", "First time", "0745153492","sonia@yahoo.com", 11, 5,
					"Va astept in numar cat mai mare","Jun 30 2022","9:00 PM","Baza sportivă Gheorgheni"), "sonia@yahoo.com");
			eventService.createEvent(new EventRequestDTO("Tennis", "Professional", "0745664688","moldo@gmail.com", 3, 25,
					"Am rugamintea sa va aduceti echipamentele proprii, Va multumesc!","Jun 26 2022","4:00 PM","Baza sportivă Unirea"), "moldo@gmail.com");
			eventService.createEvent(new EventRequestDTO("Running", "Intermediate", "0743236323","dragomir@gmail.com", 1, 0,
					"Caut un insotitor pentru un jogging de dimineata ","Jun 30 2022","8:00 AM","Parcul central"), "dragomir@gmail.com");
			eventService.createEvent(new EventRequestDTO("Bowling", "First time", "0743533431","dragomir@gmail.com", 1, 20,
					"Am nevoie de cineva care sa ma invete bowling. Suna-ma pentru mai multe detalii","Jun 28 2022","5:00 pM","Multiplex Leul"), "dragomir@gmail.com");

		};
	}

}
