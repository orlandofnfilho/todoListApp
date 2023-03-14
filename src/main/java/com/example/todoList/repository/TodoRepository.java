package com.example.todoList.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todoList.model.Todo;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long>{

}
