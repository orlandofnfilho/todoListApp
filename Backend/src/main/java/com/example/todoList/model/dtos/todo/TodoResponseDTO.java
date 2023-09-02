package com.example.todoList.model.dtos.todo;

import com.example.todoList.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class TodoResponseDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String titulo;
    private Status status;
    private Instant createdAt;
}
