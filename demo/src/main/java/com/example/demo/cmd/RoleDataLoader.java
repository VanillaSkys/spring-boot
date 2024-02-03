package com.example.demo.cmd;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.entity.RoleEntity;
import com.example.demo.repository.RoleRepository;

@Component
public class RoleDataLoader implements CommandLineRunner{

    private RoleRepository roleRepository;

    public RoleDataLoader(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        createRoleIfNotExists("USER");
        createRoleIfNotExists("ADMIN");
    }

    private void createRoleIfNotExists(String roleName) {
        if (!roleRepository.existsByName(roleName)) {
            RoleEntity newRole = new RoleEntity();
            newRole.setName(roleName);
            roleRepository.save(newRole);
        }
    }
}

