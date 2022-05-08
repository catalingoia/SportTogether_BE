package com.example.licenta.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventResponseDTO {
    private String id;
    private String name;
    private String location;
    private Float price;
    private Integer nrOfParticipants;
    private Date createTimestamp;
    private Date updateTimestamp;
}
