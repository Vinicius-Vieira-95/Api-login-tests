package com.vncautenticacao.vnc2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vncautenticacao.vnc2.entities.Role;

public interface RoleRepository  extends JpaRepository<Role, Long>{
    
}
