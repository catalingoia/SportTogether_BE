package com.example.licenta.service;

import com.example.licenta.DTOs.EventRequestDTO;
import com.example.licenta.DTOs.EventResponseDTO;

import java.util.List;

public interface EventService {

    EventResponseDTO createEvent(EventRequestDTO eventRequestDTO, String userId);

    EventResponseDTO updateEvent(String eventId, EventRequestDTO eventRequestDTO);

    List<EventResponseDTO> getAllEvents();

    EventResponseDTO getEvent(String userId);

    void deleteEvent(String userId);

}
