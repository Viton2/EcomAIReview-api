package com.vitor.oliveira.ecomaireviewapi.controller;

import com.vitor.oliveira.ecomaireviewapi.model.User;
import com.vitor.oliveira.ecomaireviewapi.model.UserEntity;
import com.vitor.oliveira.ecomaireviewapi.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.ok(userService.getUser());
    }
}
