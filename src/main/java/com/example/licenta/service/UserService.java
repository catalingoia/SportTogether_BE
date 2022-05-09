package com.example.licenta.service;

import com.example.licenta.DTOs.AppUserRequestDTO;
import com.example.licenta.DTOs.AppUserResponseDTO;
import com.example.licenta.entity.AppUser;
import com.example.licenta.entity.Role;

import java.util.List;

public interface UserService {
    AppUserResponseDTO saveUser(AppUserRequestDTO user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    AppUser getUser(String username);
    List<AppUserResponseDTO> getUsers();

}
