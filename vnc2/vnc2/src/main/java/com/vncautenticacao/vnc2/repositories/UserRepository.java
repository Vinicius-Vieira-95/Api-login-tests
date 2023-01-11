package com.vncautenticacao.vnc2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vncautenticacao.vnc2.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
}
