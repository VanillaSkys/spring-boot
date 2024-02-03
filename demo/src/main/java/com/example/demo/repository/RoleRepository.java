package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.RoleEntity;


public interface RoleRepository extends CrudRepository<RoleEntity, String> {
    Optional<RoleEntity> findByName(String name);
    boolean existsByName(String name);
    
}
