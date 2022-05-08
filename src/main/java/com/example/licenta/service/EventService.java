package com.example.licenta.service;

import com.example.licenta.DTOs.EventRequestDTO;
import com.example.licenta.DTOs.EventResponseDTO;

import java.util.List;

public interface EventService {

    EventResponseDTO createStory(EventRequestDTO eventRequestDTO, String userId);

    EventResponseDTO updateStory(String eventId, EventRequestDTO eventRequestDTO);

    List<EventResponseDTO> getAllStories();

    EventResponseDTO getStory(String userId);

    void deleteStory(String userId);

}
