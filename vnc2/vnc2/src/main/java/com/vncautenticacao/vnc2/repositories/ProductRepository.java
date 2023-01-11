package com.vncautenticacao.vnc2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vncautenticacao.vnc2.entities.Products;

public interface ProductRepository extends JpaRepository<Products, Long>{
    
}
