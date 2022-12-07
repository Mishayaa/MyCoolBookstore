package com.example.myCoolBookstore.service;

import org.springframework.stereotype.Service;
import com.example.myCoolBookstore.entity.User;
import com.example.myCoolBookstore.repo.UserRepository;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findByLogin(String username) {
        return userRepository.findByEmail(username);
    }
}