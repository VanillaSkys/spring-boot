package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "roles")
@Data
public class RoleEntity extends BaseEntity {
    
    @Column(nullable = false, unique = true)
    private String name;
    
    public RoleEntity() {
    }
    public RoleEntity(String name) {
        this.name = name;
    }
}
