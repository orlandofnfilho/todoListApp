package com.example.todoList.services;

import com.example.todoList.exceptions.ResourceNotFoundException;
import com.example.todoList.model.dtos.user.UserMapper;
import com.example.todoList.model.dtos.user.UserRequestDTO;
import com.example.todoList.model.dtos.user.UserResponseDTO;
import com.example.todoList.model.entities.User;
import com.example.todoList.repositories.ProfileRepository;
import com.example.todoList.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;

    public UserResponseDTO addUser(UserRequestDTO dto){
        User newUser = UserMapper.fromDTO(dto);
        newUser.setProfile(profileRepository.findById(2L).get());
        return UserMapper.fromEntity(userRepository.save(newUser));
    }


    public UserResponseDTO findUserById(Long id){
        User user = getUser(id);
        return UserMapper.fromEntity(user);
    }

    @Transactional(readOnly = true)
    public User getUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("User not found id: "+ id));
    }

    @Transactional(readOnly = true)
    public Page<UserResponseDTO> findAllPaged(PageRequest pageRequest){
        Page<User> users = userRepository.findAll(pageRequest);
        return users.map(UserMapper::fromEntity);
    }

    public UserResponseDTO updateUser(Long id, UserRequestDTO dto){
        User user = userRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("User not found id: "+ id));
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(new BCryptPasswordEncoder().encode(dto.getPassword()));
        user.setPhotoUrl(dto.getPhotoUrl());
        return UserMapper.fromEntity(user);
    }

    public void deleteUser(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found id: "+ id));
        userRepository.delete(user);
    }

    public User findByEmail(String email){
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found email: "+email));
    }

}
