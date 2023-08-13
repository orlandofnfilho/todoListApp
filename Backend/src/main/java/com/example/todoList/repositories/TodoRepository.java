package com.example.todoList.repositories;

import com.example.todoList.model.entities.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long>{

}
