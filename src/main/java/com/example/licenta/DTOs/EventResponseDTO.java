package com.example.licenta.DTOs;

import com.example.licenta.entity.AppUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventResponseDTO {
    private String id;
    private String sport;
    private String level;
    private String location;
    private Double price;
    private Integer maxPlayers;
    private Collection<AppUser> participants;
    private Date createTimestamp;
    private Date updateTimestamp;
    private String email;
    private String firstName;
    private String lastName;
    private Boolean accepted;
    private Boolean rejected;
}

