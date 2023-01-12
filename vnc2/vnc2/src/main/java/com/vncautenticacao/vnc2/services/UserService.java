package com.vncautenticacao.vnc2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.vncautenticacao.vnc2.dtos.UserDto;
import com.vncautenticacao.vnc2.entities.Role;
import com.vncautenticacao.vnc2.entities.User;
import com.vncautenticacao.vnc2.repositories.RoleRepository;
import com.vncautenticacao.vnc2.repositories.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public BCryptPasswordEncoder passwordEncoder() {
      return new BCryptPasswordEncoder();
    }

    @Transient
    public User createUser(User user) {
        user.setPassword(passwordEncoder().encode(user.getPassword()));
        return userRepository.save(user);
    }

    public List<User> listUsers() {
        return userRepository.findAll();
    }

    @Transient
    public User addRoleToUser(UserDto createUserRoledto) {

        Optional<User>  user1 = userRepository.findByEmail(createUserRoledto.getEmail());
        String roleName = roleRepository.findByName(createUserRoledto.getRole()).getName();
        System.out.println(roleName);

        if(user1.isEmpty()){
          throw new Error("User not found");
        }
        if(roleName.isEmpty()){
          throw new Error("Role dosn't exist");
        }

        User user = user1.get();
        user.getRoles().add(new Role(roleName));
        userRepository.save(user);
        return user;
    }
}
