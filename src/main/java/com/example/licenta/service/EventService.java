package com.example.licenta.service;

import com.example.licenta.DTOs.EventRequestDTO;
import com.example.licenta.DTOs.EventResponseDTO;

import java.util.List;

public interface EventService {

    EventResponseDTO createEvent(EventRequestDTO eventRequestDTO, String email);

    EventResponseDTO updateEvent(String eventId, EventRequestDTO eventRequestDTO);

    List<EventResponseDTO> getAllEvents();

    List<EventResponseDTO> getEventsByApproved(Boolean approved);


    List<EventResponseDTO> getEventsByAccepted(Boolean accepted);

    List<EventResponseDTO> getEventsByRejected(Boolean rejected);


    EventResponseDTO getEvent(String userId);

    void acceptEvent(Boolean accepted, String eventId);

    void deleteEvent(String userId);

}
