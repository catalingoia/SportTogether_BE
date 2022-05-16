package com.example.licenta.service;

import com.example.licenta.DTOs.EventRequestDTO;
import com.example.licenta.DTOs.EventResponseDTO;
import com.example.licenta.entity.Event;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public interface EventService {

    EventResponseDTO createEvent(EventRequestDTO eventRequestDTO, String email);

    EventResponseDTO updateEvent(String eventId, EventRequestDTO eventRequestDTO);

    Map<String, Object> getAllEvents(Integer pageNo, Integer pageSize);

    Map<String, Object> getUnapprovedEvents(Integer pageNo, Integer pageSize);

    Map<String, Object> getAcceptedEvents(Integer pageNo, Integer pageSize);

    List<EventResponseDTO> getEventsByRejected(Boolean rejected);

    EventResponseDTO getEvent(String eventId);

    void acceptEvent(Boolean accepted, String eventId);

    void deleteEvent(String eventId);

    void joinEvent(String eventId, String email);

}
