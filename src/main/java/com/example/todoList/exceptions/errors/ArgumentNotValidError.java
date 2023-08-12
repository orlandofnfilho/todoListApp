package com.example.todoList.exceptions.errors;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
public class ArgumentNotValidError implements Serializable {
    private static final long serialVersionUID = 1L;

    private Instant timestamp;
    private Integer status;
    private String error;
    private List<String> message;
    private String path;

}