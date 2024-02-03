package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.ProductEntity;

public interface ProductRepository extends CrudRepository<ProductEntity, String> {

}
