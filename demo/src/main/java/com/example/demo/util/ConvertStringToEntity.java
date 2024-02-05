package com.example.demo.util;

import com.example.demo.entity.RoleEntity;

public class ConvertStringToEntity {
    public ConvertStringToEntity() {
    }

    public static RoleEntity convertToRoleEntity(String name) {
        return new RoleEntity(name);
    }
}
