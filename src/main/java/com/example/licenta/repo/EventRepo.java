package com.example.licenta.repo;

import com.example.licenta.model.Event;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepo extends JpaRepository<Event, String> {
    List<Event> findByUserEmailAndAcceptedFalseAndRejectedFalse(String email);
    List<Event> findByUserEmailAndAcceptedTrue(String email);
    List<Event> findByUserEmailAndRejectedTrue(String email);
    List<Event> findByUserEmail(String email);
    Page<Event> findByAcceptedTrueOrderByCreateTimestampDesc(Pageable pageable);
    Page<Event> findByAcceptedFalseAndRejectedFalseOrderByCreateTimestampDesc(Pageable pageable);
    Page<Event> findByAcceptedTrueOrRejectedTrueOrderByCreateTimestampDesc(Pageable pageable);
}
