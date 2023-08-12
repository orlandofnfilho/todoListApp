package com.example.todoList.controllers;

import com.example.todoList.model.entities.Todo;
import com.example.todoList.repositories.TodoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping(value = "api/v1/todolist")
@Api(value = "API REST To-do List")
@CrossOrigin(origins = "*")
public class TodoController {

	@Autowired
	private TodoRepository repository;

	@GetMapping
	@ApiOperation(value = "Retorna todas as tarefas")
	public List<Todo> getAllTodos() {
		return repository.findAll();
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Retorna uma terefa pelo Id")
	public Optional<Todo> getTodoById(@PathVariable Long id) {
		return repository.findById(id);
	}

	@PostMapping
	@ApiOperation(value = "Adiciona uma nova tarefa")
	public Todo saveTodo(@RequestBody Todo todo) {
		return repository.save(todo);
	}

	@PutMapping
	@ApiOperation(value = "Atualiza uma tarefa existente")
	public Todo updateTodo(@RequestBody Todo todo) {
		return repository.save(todo);

	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Deleta uma tarefa pelo Id")
	public void deleteTodoById(@PathVariable Long id) {
		repository.deleteById(id);
	}

	@DeleteMapping("/clean")
	@ApiOperation(value = "Limpa todas as tarefas")
	public void deleteAll() {
		repository.deleteAll();
	}

}

