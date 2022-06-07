package com.example.licenta.service;

import com.example.licenta.DTOs.AppUserRequestDTO;
import com.example.licenta.DTOs.AppUserResponseDTO;
import com.example.licenta.model.AppUser;
import com.example.licenta.model.Role;

import java.util.List;

public interface UserService {
    AppUserResponseDTO saveUser(AppUserRequestDTO user);
    Role saveRole(Role role);
    void addRoleToUser(String email, String roleName);
    AppUser getUser(String email);
    List<AppUserResponseDTO> getUsers();

}
