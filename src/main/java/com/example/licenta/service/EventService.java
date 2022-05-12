package com.example.licenta.service;

import com.example.licenta.DTOs.EventRequestDTO;
import com.example.licenta.DTOs.EventResponseDTO;

import java.util.List;

public interface EventService {

    EventResponseDTO createEvent(EventRequestDTO eventRequestDTO, String email);

    EventResponseDTO updateEvent(String eventId, EventRequestDTO eventRequestDTO);

    List<EventResponseDTO> getAllEvents();

    List<EventResponseDTO> getEventsByAccepted(Boolean accepted);

    EventResponseDTO getEvent(String userId);

    void deleteEvent(String userId);

}
