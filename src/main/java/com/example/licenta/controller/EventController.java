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

    @DeleteMapping("/event/delete/{eventId}")
    public ResponseEntity<Void>deleteEvent(@PathVariable(value = "eventId") String eventId){
        eventService.deleteEvent( eventId);
        return ResponseEntity.ok().build();
    }



}
