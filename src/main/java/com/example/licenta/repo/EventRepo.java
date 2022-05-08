package com.example.licenta.repo;

import com.example.licenta.entity.AppUser;
import com.example.licenta.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepo extends JpaRepository<Event, String> {

}
