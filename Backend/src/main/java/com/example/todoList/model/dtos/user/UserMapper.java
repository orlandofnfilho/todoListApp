package com.example.todoList.model.dtos.user;

import com.example.todoList.model.entities.Profile;
import com.example.todoList.model.entities.User;
import com.example.todoList.repositories.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

public class UserMapper {

    public static User fromDTO(UserRequestDTO dto){
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPhotoUrl(dto.getPhotoUrl());
        return user;
    }

    public static UserResponseDTO fromEntity(User entity){
        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setEmail(entity.getEmail());
        dto.setPhotoUrl(entity.getPhotoUrl());
        dto.setProfile(entity.getProfile());
        return dto;
    }
}
