package com.vncautenticacao.vnc2.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vncautenticacao.vnc2.entities.Products;

@RestController
@RequestMapping("/products")
public class ProductController {
    
    @GetMapping
    public List<Products> list() {
        List<Products> products = new ArrayList<>();
        products.add(new Products(1L, "Product 1", "Eltrônico",  100.0));
        products.add(new Products(2L, "Product 2", "Mesa",  300.0));
        products.add(new Products(3L, "Product 3", "Tv",  250.0));
        products.add(new Products(4L, "Product 4", "Celular",  400.0));
        return products;
    }
}
