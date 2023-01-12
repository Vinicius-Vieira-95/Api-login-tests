package com.vncautenticacao.vnc2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vncautenticacao.vnc2.dtos.UserDto;
import com.vncautenticacao.vnc2.entities.User;
import com.vncautenticacao.vnc2.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public List<User> listUsers() {
      return userService.listUsers();
    }

    @PostMapping("/create")
    public User create(@RequestBody User user) {
      return userService.createUser(user);
    }

    @PostMapping("/role")
    public ResponseEntity<User> role(@RequestBody UserDto createUserRoleDto) {
      return ResponseEntity.ok().body(userService.addRoleToUser(createUserRoleDto));
    }
}
