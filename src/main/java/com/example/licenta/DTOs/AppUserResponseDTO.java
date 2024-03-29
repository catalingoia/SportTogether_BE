package com.example.licenta.DTOs;

import com.example.licenta.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUserResponseDTO {

    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Collection<Role> roles;
    private Collection<EventResponseDTO> events;
    private Collection<EventResponseDTO> attendingEvents;
}
