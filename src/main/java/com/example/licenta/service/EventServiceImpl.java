package com.example.licenta.service;

import com.example.licenta.DTOs.EventRequestDTO;
import com.example.licenta.DTOs.EventResponseDTO;
import com.example.licenta.entity.AppUser;
import com.example.licenta.entity.Event;
import com.example.licenta.mapper.EventMapper;
import com.example.licenta.mapper.UserMapper;
import com.example.licenta.repo.EventRepo;
import com.example.licenta.repo.RoleRepo;
import com.example.licenta.repo.UserRepo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class EventServiceImpl implements EventService{
    private final EventMapper eventMapper;
    private final EventRepo eventRepo;
    private final UserRepo userRepo;

    @Override
    public EventResponseDTO createEvent(EventRequestDTO eventRequestDTO, String email) {
        Event event = eventMapper.eventRequestDTOToEvent(eventRequestDTO);
        event.setUser(userRepo.findByEmail(email));
        event.setEmail(email);
        return eventMapper.eventToEventResponseDTO(eventRepo.save(event));
    }

    @Override
    public EventResponseDTO updateEvent(String eventId, EventRequestDTO eventRequestDTO) {
        return null;
    }

    @Override
    public List<EventResponseDTO> getAllEvents() {
        return eventMapper.eventListToEventResponseDTOList(eventRepo.findAll());
    }

    @Override
    public List<EventResponseDTO> getEventsByAccepted(Boolean accepted) {
        return eventMapper.eventListToEventResponseDTOList(eventRepo.findByAccepted(accepted));
    }

    @Override
    public EventResponseDTO getEvent(String userId) {
        return null;
    }

    @Override
    public void deleteEvent(String userId) {

    }
}
