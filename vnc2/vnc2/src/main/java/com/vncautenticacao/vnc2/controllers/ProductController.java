package com.vncautenticacao.vnc2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vncautenticacao.vnc2.entities.Products;
import com.vncautenticacao.vnc2.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
    
    @Autowired
    private ProductService listProductService;

    @GetMapping
    public List<Products> list() {
        return listProductService.listAll();
    }
}
