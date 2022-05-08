package com.example.licenta.mapper;

import com.example.licenta.DTOs.EventRequestDTO;
import com.example.licenta.DTOs.EventResponseDTO;
import com.example.licenta.entity.Event;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EventMapper {
    EventResponseDTO EventToEventResponseDTO(Event Event);
    List<EventResponseDTO> EventListToEventResponseDTOList(List<Event> EventList);
    Event EventRequestDTOToEvent(EventRequestDTO EventRequestDTO);
}
