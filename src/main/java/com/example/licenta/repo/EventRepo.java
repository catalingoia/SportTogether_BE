package com.example.licenta.repo;

import com.example.licenta.entity.AppUser;
import com.example.licenta.entity.Event;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepo extends JpaRepository<Event, String> {
    List<Event> findByAcceptedIs(Boolean accepted);
    List<Event> findByRejectedIs(Boolean rejected);
    List<Event> findByAcceptedIsAndRejectedIs(Boolean approved, Boolean approved2);

}
