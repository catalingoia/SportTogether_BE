package com.example.licenta.repo;

import com.example.licenta.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, String> {
    Role findByName(String name);
}
