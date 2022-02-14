package com.example.todoList.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todoList.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long>{

}
