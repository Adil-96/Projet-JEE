package com.client.auth.service;
import com.client.auth.Dao.RoleDao;
import com.client.auth.model.User;
import com.client.auth.Dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userRepository;
    @Autowired
    private RoleDao roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(Arrays.asList(roleRepository.findByName(user.getFonction()))));
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
