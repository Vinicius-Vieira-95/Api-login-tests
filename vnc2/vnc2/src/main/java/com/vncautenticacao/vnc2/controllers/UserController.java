package com.vncautenticacao.vnc2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vncautenticacao.vnc2.entities.User;
import com.vncautenticacao.vnc2.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private UserService userService;


    @PostMapping("/create")
    public User create(@RequestBody User user) {
      return userService.createUser(user);
    }
}
