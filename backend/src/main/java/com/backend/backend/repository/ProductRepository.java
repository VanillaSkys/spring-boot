package com.backend.backend.repository;

import org.springframework.data.repository.CrudRepository;

import com.backend.backend.entity.ProductEntity;

public interface ProductRepository extends CrudRepository<ProductEntity, String> {
    
}
