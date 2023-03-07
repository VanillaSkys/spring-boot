package com.backend.backend.entity;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class ProductEntity {
    @Id
    @GenericGenerator(name = "uuid2", strategy ="uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(length = 255, nullable = false, updatable = false)
    private String id;

    @Column(length = 255, nullable = false)
    private String name;

    @Column(nullable = false, scale = 2)
    private float price;

    @Column(length = 255, nullable = true)
    private String image;
}
