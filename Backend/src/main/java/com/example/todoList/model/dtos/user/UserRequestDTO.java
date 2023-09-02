package com.example.todoList.model.dtos.user;


import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserRequestDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private String email;
    private String password;
    private String photoUrl;
}
