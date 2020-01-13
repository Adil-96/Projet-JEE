package com.client.auth.service;
import com.client.auth.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}