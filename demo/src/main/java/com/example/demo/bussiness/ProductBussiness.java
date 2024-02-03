package com.example.demo.bussiness;

import org.springframework.stereotype.Service;

import com.example.demo.entity.ProductEntity;
import com.example.demo.exception.BaseException;
import com.example.demo.model.request.CreateProductRequest;
import com.example.demo.service.abstractions.IProductService;

@Service
public class ProductBussiness {
    private final IProductService productService;
    
    public ProductBussiness(IProductService productService) {
        this.productService = productService;
    }
    public ProductEntity createProduct(CreateProductRequest request) throws BaseException {
        ProductEntity productEntity = productService.createProduct(request.getName());
        return productEntity;
    }
}
