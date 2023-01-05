package com.clienteapi.vnc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clienteapi.vnc.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
}
