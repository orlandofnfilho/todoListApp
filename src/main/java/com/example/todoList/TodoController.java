package com.example.todoList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@RestController
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping
public class TodoController {

	@Autowired
	private TodoRepository repository;
	
	@GetMapping("/todos")
	public List<Todo> getAllTodos() {
		return repository.findAll();
	}

	@GetMapping("/todos/{id}")
	public Optional<Todo> getTodoById(@PathVariable Long id) {
		return repository.findById(id);
	}

	@PostMapping("/todos")
	public Todo saveTodo(@RequestBody Todo todo) {
		return repository.save(todo);
	}

	@PutMapping("/todos")
	public Todo updateTodo(@RequestBody Todo todo) {
		return repository.save(todo);

	}

	@DeleteMapping("/todos/{id}")
	public void deleteTodoById(@PathVariable Long id) {
		repository.deleteById(id);
	}

}
