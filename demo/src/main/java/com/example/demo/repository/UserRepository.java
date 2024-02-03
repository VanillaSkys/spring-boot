package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.UserEntity;
import java.util.Optional;


public interface UserRepository extends CrudRepository<UserEntity, String> {
    Optional<UserEntity> findByUsername(String username);
    boolean existsByUsername(String username);
}
