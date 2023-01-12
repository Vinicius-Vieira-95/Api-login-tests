package com.vncautenticacao.vnc2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vncautenticacao.vnc2.entities.Role;
import com.vncautenticacao.vnc2.repositories.RoleRepository;

@RestController
@RequestMapping("/roles")
public class RoleController {
    
    @Autowired
    private RoleRepository roleRepository;

    @PostMapping("/create-role")
    public Role create(@RequestBody Role role) {
        return roleRepository.save(role);
    }

    @GetMapping("/list-roles")
    public List<Role> listRoles() {
        return roleRepository.findAll();
    }
}
