package com.example.licenta.repo;

import com.example.licenta.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<AppUser, String> {
    AppUser findByEmail(String email);

}
