package com.example.licenta.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUserRequestDTO {

    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String phone;
}
