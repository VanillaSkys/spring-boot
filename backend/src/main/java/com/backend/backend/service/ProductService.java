package com.backend.backend.service;

import com.backend.backend.repository.ProductRepository;

import org.springframework.stereotype.Service;

import com.backend.backend.entity.ProductEntity;

@Service
public class ProductService {
    
    private ProductRepository repository;    

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Iterable<ProductEntity> findAllByProduct() {
        return repository.findAll();
    }

}
