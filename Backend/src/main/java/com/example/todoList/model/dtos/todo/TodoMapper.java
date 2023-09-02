package com.example.todoList.model.dtos.todo;

import com.example.todoList.model.entities.Todo;

public class TodoMapper {

    public static Todo fromDTO(TodoRequestDTO dto){
        return new Todo();
    }
}
