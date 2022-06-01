package com.example.licenta.controller;


import com.example.licenta.DTOs.EventRequestDTO;
import com.example.licenta.DTOs.EventResponseDTO;
import com.example.licenta.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/api")
public class EventController {
    private final EventService eventService;

    @GetMapping("/events")
    public ResponseEntity<Map<String, Object>> getAllEvents(@RequestParam(value = "page") int page,
                                                               @RequestParam(value = "size") int size)
    {
        return ResponseEntity.ok().body(eventService.getAllEvents(page, size));
    }

    @GetMapping("/events/unapproved")
    public ResponseEntity<Map<String, Object>> getUnapprovedEvents(@RequestParam(value = "page") int page,
                                                                   @RequestParam(value = "size") int size)
    {
        return ResponseEntity.ok().body(eventService.getUnapprovedEvents(page, size));
    }

    @GetMapping("/events/accepted")
    public ResponseEntity<Map<String, Object>> getAcceptedEvents(@RequestParam(value = "page") int page,
                                                                 @RequestParam(value = "size") int size){
        return ResponseEntity.ok().body(eventService.getAcceptedEvents(page,size));
    }


    @GetMapping("/events/user/pending")
    public ResponseEntity<List<EventResponseDTO>> getPendingEventsByEmail(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return ResponseEntity.ok().body(eventService.getPendingEventsByEmail(auth.getName()));
    }

    @GetMapping("/events/user/accepted")
    public ResponseEntity<List<EventResponseDTO>> getAcceptedEventsByEmail(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return ResponseEntity.ok().body(eventService.getAcceptedEventsByEmail(auth.getName()));
    }

    @GetMapping("/events/user/rejected")
    public ResponseEntity<List<EventResponseDTO>> getRejectedEventsByEmail(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return ResponseEntity.ok().body(eventService.getRejectedEventsByEmail(auth.getName()));
    }
    @PostMapping("/events/create")
    public ResponseEntity<EventResponseDTO>createEvent(@RequestBody EventRequestDTO event){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/event/save").toUriString());
        return ResponseEntity.created(uri).body(eventService.createEvent(event, auth.getName()));
    }

    @PostMapping("/events/accept/{eventId}")
    public ResponseEntity<?>acceptEvent(@RequestBody Boolean approved,
                                        @PathVariable(value = "eventId") String eventId){
        eventService.acceptEvent(approved, eventId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/events/join/{eventId}")
    public ResponseEntity<Void>joinEvent(@RequestBody String email,
                                        @PathVariable(value = "eventId") String eventId){
        eventService.joinEvent(eventId, email);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/events/leave/{eventId}")
    public ResponseEntity<Void>leaveEvent(@RequestBody String email,
                                         @PathVariable(value = "eventId") String eventId){
        eventService.leaveEvent(eventId, email);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/events/delete/{eventId}")
    public ResponseEntity<Void>deleteEvent(@PathVariable(value = "eventId") String eventId){
        eventService.deleteEvent( eventId);
        return ResponseEntity.ok().build();
    }



}
