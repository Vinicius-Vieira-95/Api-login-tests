package com.vncautenticacao.vnc2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vncautenticacao.vnc2.entities.Products;
import com.vncautenticacao.vnc2.repositories.ProductRepository;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Products> listAll() {
        return productRepository.findAll();
    }
    
}
