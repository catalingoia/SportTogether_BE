package com.example.licenta.mapper;

import com.example.licenta.DTOs.EventRequestDTO;
import com.example.licenta.DTOs.EventResponseDTO;
import com.example.licenta.entity.Event;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EventMapper {
    EventResponseDTO eventToEventResponseDTO(Event Event);
    List<EventResponseDTO> eventListToEventResponseDTOList(List<Event> EventList);
    Event eventRequestDTOToEvent(EventRequestDTO EventRequestDTO);
}
