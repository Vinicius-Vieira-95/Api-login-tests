package com.vncautenticacao.vnc2.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vncautenticacao.vnc2.dtos.UserDto;
import com.vncautenticacao.vnc2.entities.Role;
import com.vncautenticacao.vnc2.entities.User;
import com.vncautenticacao.vnc2.repositories.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User execute(UserDto createUserRoleDTO) {

        Optional<User> userExists = userRepository.findById(createUserRoleDTO.getIdUser());
        List<Role> roles = new ArrayList<>();
    
        if (userExists.isEmpty()) {
          throw new Error("User does not exists!");
        }
    
        roles = createUserRoleDTO.getIdsRoles().stream().map(role -> {
          return new Role(role);
        }).collect(Collectors.toList());
    
        User user = userExists.get();
    
        user.setRoles(roles);
    
        userRepository.save(user);
    
        return user;
    
      }
}
