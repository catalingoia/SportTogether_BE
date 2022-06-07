package com.example.licenta.service;

import com.example.licenta.DTOs.EventRequestDTO;
import com.example.licenta.DTOs.EventResponseDTO;
import com.example.licenta.model.AppUser;
import com.example.licenta.model.Event;
import com.example.licenta.mapper.EventMapper;
import com.example.licenta.repo.EventRepo;
import com.example.licenta.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.*;

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
    public Map<String, Object> getAllEvents(Integer pageNo, Integer pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Map<String, Object> response = new HashMap<>();
        Page<Event> events = eventRepo.findByAcceptedTrueOrRejectedTrue(paging);
        response.put("events",  eventMapper.eventListToEventResponseDTOList(events.getContent()));
        response.put("currentPage", events.getNumber());
        response.put("totalItems", events.getTotalElements());
        response.put("totalPages", events.getTotalPages());

        return response;
    }
    @Override
    public Map<String, Object> getUnapprovedEvents(Integer pageNo, Integer pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Map<String, Object> response = new HashMap<>();
        Page<Event> events = eventRepo.findByAcceptedFalseAndRejectedFalse(paging);
        response.put("events",  eventMapper.eventListToEventResponseDTOList(events.getContent()));
        response.put("currentPage", events.getNumber());
        response.put("totalItems", events.getTotalElements());
        response.put("totalPages", events.getTotalPages());

        return response;
    }

    @Override
    public Map<String, Object> getAcceptedEvents(Integer pageNo, Integer pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Map<String, Object> response = new HashMap<>();
        Page<Event> events = eventRepo.findByAcceptedTrue(paging);
        response.put("events",  eventMapper.eventListToEventResponseDTOList(events.getContent()));
        response.put("currentPage", events.getNumber());
        response.put("totalItems", events.getTotalElements());
        response.put("totalPages", events.getTotalPages());

        return response;
    }

    @Override
    public List<EventResponseDTO> getPendingEventsByEmail(String email) {
        return eventMapper.eventListToEventResponseDTOList(eventRepo.findByUserEmailAndAcceptedFalseAndRejectedFalse(email));
    }

    @Override
    public List<EventResponseDTO> getAcceptedEventsByEmail(String email) {
        return eventMapper.eventListToEventResponseDTOList(eventRepo.findByUserEmailAndAcceptedTrue(email));
    }

    @Override
    public List<EventResponseDTO> getRejectedEventsByEmail(String email) {
        return eventMapper.eventListToEventResponseDTOList(eventRepo.findByUserEmailAndRejectedTrue(email));
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
            event.setRejected(false);
        }else {
            event.setRejected(true);
            event.setAccepted(false);
        }
    }

    @Override
    public void leaveEvent(String eventId, String email) {
        Event event = eventRepo.findById(eventId).orElseThrow(() -> new EntityNotFoundException(eventId));
        AppUser user = userRepo.findByEmail(email);
        System.out.println(user);
        event.getParticipants().remove(user);
        Collection<AppUser> currentParticipants = event.getParticipants();
         if(!currentParticipants.contains(user)) {
            currentParticipants.remove(user);
        } else throw new RuntimeException("User is not a participant");
        event.setParticipants(currentParticipants);
        eventRepo.save(event);

    }

    @Override
    public void joinEvent(String eventId, String email) {
        Event event = eventRepo.findById(eventId).orElseThrow(() -> new EntityNotFoundException(eventId));
        System.out.println("1111" + event);
        AppUser user = userRepo.findByEmail(email);
        System.out.println("2222" + user);
        Collection<AppUser> currentParticipants = event.getParticipants();
        System.out.println("3333" + currentParticipants);

        if(currentParticipants.size() == event.getMaxPlayers())
            throw new RuntimeException("Event is full");
        if(!currentParticipants.contains(user)) {
            currentParticipants.add(user);
        } else throw new RuntimeException("User is already a participant");
        System.out.println("55555" + currentParticipants);
        event.setParticipants(currentParticipants);
        System.out.println("6666" + event);
        eventRepo.save(event);
    }

    @Override
    public void deleteEvent(String eventId) {
        Event event = eventRepo.findById(eventId).orElseThrow(() -> new EntityNotFoundException(eventId));
        eventRepo.delete(event);
    }


}
