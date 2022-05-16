package com.example.licenta.repo;

import com.example.licenta.entity.AppUser;
import com.example.licenta.entity.Event;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepo extends JpaRepository<Event, String> {
    Page<Event> findByAcceptedTrue(Pageable pageable);
    List<Event> findByRejectedIs(Boolean rejected);
    Page<Event> findByAcceptedFalseAndRejectedFalse(Pageable pageable);
    Page<Event> findByAcceptedTrueOrRejectedTrue(Pageable pageable);
}
