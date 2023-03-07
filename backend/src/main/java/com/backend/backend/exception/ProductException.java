package com.backend.backend.exception;

public class ProductException extends BaseException {
    public ProductException(String code) {
        super("product." + code);
    }

    public static ProductException productNull() {
        return new ProductException("data.null");
    }

}
