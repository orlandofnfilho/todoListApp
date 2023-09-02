package com.example.todoList.services;

import com.example.todoList.model.entities.User;
import com.example.todoList.repositories.ProfileRepository;
import com.example.todoList.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private UserRepository userRepository;
    private ProfileRepository profileRepository;

    public User saveUser(){
        return new User();
    }
}
