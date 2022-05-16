package com.example.licenta.controller;

import com.example.licenta.DTOs.AppUserRequestDTO;
import com.example.licenta.DTOs.AppUserResponseDTO;
import com.example.licenta.DTOs.EventRequestDTO;
import com.example.licenta.DTOs.EventResponseDTO;
import com.example.licenta.service.EventService;
import com.example.licenta.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/api")
public class EventController {
    private final EventService eventService;

    @GetMapping("/events")
    public ResponseEntity<List<EventResponseDTO>> getAllEvents(){
        return ResponseEntity.ok().body(eventService.getAllEvents());
    }


    @GetMapping("/events/unapproved")
    public ResponseEntity<List<EventResponseDTO>> getEventByUnapproved(){
        return ResponseEntity.ok().body(eventService.getEventsByApproved(false));
    }


    @GetMapping("/events/accepted")
    public ResponseEntity<List<EventResponseDTO>> getEventsByAccepted(){
        return ResponseEntity.ok().body(eventService.getEventsByAccepted(true));
    }

    @GetMapping("/events/rejected")
    public ResponseEntity<List<EventResponseDTO>> getEventsByRejected(){
        return ResponseEntity.ok().body(eventService.getEventsByRejected(true));
    }

    @PostMapping("/event/save/{email}")
    public ResponseEntity<EventResponseDTO>createEvent(@RequestBody EventRequestDTO event,
                                                    @PathVariable(value = "email") String email){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/event/save").toUriString());
        return ResponseEntity.created(uri).body(eventService.createEvent(event, email));
    }

    @PostMapping("/admin/accept/{eventId}")
    public ResponseEntity<?>acceptEvent(@RequestBody Boolean approved,
                                        @PathVariable(value = "eventId") String eventId){
        eventService.acceptEvent(approved, eventId);
        return ResponseEntity.ok().build();


    }



}
