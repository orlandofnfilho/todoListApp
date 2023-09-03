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
        User user = userRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("User not found id: "+ id));
        return user;
    }

    @Transactional(readOnly = true)
    public Page<UserResponseDTO> findAllPaged(PageRequest pageRequest){
        Page<User> users = userRepository.findAll(pageRequest);
        return users.map(UserMapper::fromEntity);
    }

}
