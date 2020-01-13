package com.client.auth.Dao;

import com.client.auth.model.Role;
import com.client.auth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RoleDao extends JpaRepository<Role, Long> {
    Role findByName(String name);
    List<Role> findAll();
}