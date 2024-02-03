package com.example.demo.service.abstractions;

import org.springframework.stereotype.Service;

import com.example.demo.entity.ProductEntity;
import com.example.demo.exception.BaseException;

@Service
public interface IProductService {
    ProductEntity createProduct(String name) throws BaseException;
}
