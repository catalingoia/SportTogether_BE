package com.example.licenta.DTOs;

import com.example.licenta.entity.AppUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventRequestDTO {
    private String sport;
    private String level;
    private String location;
    private Double price;
    private Integer maxPlayers;
}
