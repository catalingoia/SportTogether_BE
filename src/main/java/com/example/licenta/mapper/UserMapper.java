package com.example.licenta.mapper;

import com.example.licenta.DTOs.AppUserRequestDTO;
import com.example.licenta.DTOs.AppUserResponseDTO;
import com.example.licenta.entity.AppUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    AppUserResponseDTO appUserToAppUserResponseDTO(AppUser appUser);
    List<AppUserResponseDTO> appUserListToAppUserResponseDTOList(List<AppUser> appUserList);
    AppUser appUserRequestDTOToAppUser(AppUserRequestDTO appUserRequestDTO);
}