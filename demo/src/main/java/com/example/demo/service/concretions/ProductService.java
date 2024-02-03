package com.example.demo.service.concretions;

import java.util.Objects;

import org.springframework.stereotype.Service;

import com.example.demo.entity.ProductEntity;
import com.example.demo.exception.BaseException;
import com.example.demo.exception.ProductException;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.abstractions.IProductService;

@Service
public class ProductService implements IProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }
    @Override
    public ProductEntity createProduct(String name) throws BaseException {
        if(Objects.isNull(name)) {
            throw ProductException.nameNull();
        }
        
        ProductEntity entity = new ProductEntity();
        entity.setName(name);

        return repository.save(entity);
    }
}