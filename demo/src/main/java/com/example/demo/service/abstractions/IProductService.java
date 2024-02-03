package com.example.demo.service.abstractions;

import com.example.demo.entity.ProductEntity;
import com.example.demo.exception.BaseException;

public interface IProductService {
    ProductEntity createProduct(String name) throws BaseException;
}
