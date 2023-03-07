package com.backend.backend.service;

import com.backend.backend.repository.ProductRepository;

public class ProductService {
    
    private ProductRepository repository;    

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    

}
