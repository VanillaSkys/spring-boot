package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity(name = "product")
public class ProductEntity extends BaseEntity {
    @Column(nullable = false, unique = true)
    private String name;
}
