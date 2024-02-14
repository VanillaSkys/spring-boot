package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bussiness.ProductBussiness;
import com.example.demo.entity.ProductEntity;
import com.example.demo.exception.BaseException;
import com.example.demo.model.request.CreateProductRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1")
public class Product {
    private final ProductBussiness bussiness;

    public Product(ProductBussiness bussiness) {
        this.bussiness = bussiness;
    }

    @GetMapping("/public/product")
    public String findByProduct() {
        return "Sawatdee";
    }

    @GetMapping("/user/product")
    public String findAllByProduct() {
        return "Sawatdee User";
    }

    @PostMapping("/admin/product")
    public ResponseEntity<ProductEntity> createProduct(@RequestBody CreateProductRequest request) throws BaseException {
        ProductEntity response = bussiness.createProduct(request);
        return ResponseEntity.ok(response);
    }

}
