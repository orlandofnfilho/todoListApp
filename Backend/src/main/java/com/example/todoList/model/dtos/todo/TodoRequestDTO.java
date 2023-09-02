package com.example.todoList.model.dtos.todo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TodoRequestDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String titulo;
    private String status;
}
