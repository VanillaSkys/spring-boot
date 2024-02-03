package com.example.demo.exception;

public class ProductException extends BaseException {
    public ProductException(String code) {
        super("product." + code);
    }

    public static ProductException nameNull() {
        return new ProductException("name.null");
    }
}
