package com.example.licenta.DTOs;

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
    private String contactPhone;
    private String contactEmail;
    private Integer maxPlayers;
    private Integer price;
    private String description;
    private String date;
    private String time;
    private String location;
}
