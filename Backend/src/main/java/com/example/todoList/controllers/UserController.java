package com.example.todoList.controllers;

import com.example.todoList.model.dtos.user.UserRequestDTO;
import com.example.todoList.model.dtos.user.UserResponseDTO;
import com.example.todoList.services.UserService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/v1/users")
@Api(value = "API REST To-do List")
@CrossOrigin(origins = "*")
public class UserController {


    private static final String ID = "/{id}";
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDTO> addUser(@RequestBody UserRequestDTO userRequestDTO){
        UserResponseDTO response = userService.addUser(userRequestDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path(ID).buildAndExpand(response.getId()).toUri();
        return ResponseEntity.created(uri).body(response);
    }

    @GetMapping(ID)
    public ResponseEntity<UserResponseDTO> findUserById(@PathVariable Long id){
        UserResponseDTO response = userService.findUserById(id);
        return ResponseEntity.ok(response);
    }

//    @GetMapping
//    publi

}
