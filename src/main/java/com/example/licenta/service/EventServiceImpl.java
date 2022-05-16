package com.example.licenta.service;

import com.example.licenta.DTOs.EventRequestDTO;
import com.example.licenta.DTOs.EventResponseDTO;
import com.example.licenta.entity.AppUser;
import com.example.licenta.entity.Event;
import com.example.licenta.mapper.EventMapper;
import com.example.licenta.repo.EventRepo;
import com.example.licenta.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
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
        AppUser user = userRepo.findByEmail(email);
        event.setUser(user);
        event.setEmail(email);
        event.setFirstName(user.getFirstName());
        event.setLastName(user.getLastName());
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
    public List<EventResponseDTO> getEventsByApproved(Boolean approved) {
        return eventMapper.eventListToEventResponseDTOList(eventRepo.findByAcceptedIsAndRejectedIs(approved, approved));
    }

    @Override
    public List<EventResponseDTO> getEventsByAccepted(Boolean accepted) {
        return eventMapper.eventListToEventResponseDTOList(eventRepo.findByAcceptedIs(accepted));
    }

    @Override
    public List<EventResponseDTO> getEventsByRejected(Boolean rejected) {
        return eventMapper.eventListToEventResponseDTOList(eventRepo.findByRejectedIs(rejected));
    }

    @Override
    public EventResponseDTO getEvent(String userId) {
        return null;
    }

    @Override
    public void acceptEvent(Boolean approved, String eventId) {
        Event event = eventRepo.findById(eventId).orElseThrow(() -> new EntityNotFoundException(eventId));
        if(approved) {
            event.setAccepted(true);
            System.out.println(event.getAccepted());
        }else
            event.setRejected(true);
            System.out.println(event.getRejected());

    }

    @Override
    public void deleteEvent(String userId) {

    }


}
