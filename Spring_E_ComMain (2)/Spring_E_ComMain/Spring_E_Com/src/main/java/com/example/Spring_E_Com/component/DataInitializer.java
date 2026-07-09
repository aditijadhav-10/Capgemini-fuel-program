package com.example.Spring_E_Com.component;

import com.example.Spring_E_Com.model.Role;
import com.example.Spring_E_Com.repository.RoleRepository;
import com.example.Spring_E_Com.role.RoleName;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

//    @Autowired
//    private com.example.Spring_E_Com.role.Role RoleName;

    private final RoleRepository roleRepository;

    @Override
    public void run(String... args) {

        createRoleIfNotExist(RoleName.ADMIN.name(), "System Administrator");
        createRoleIfNotExist(RoleName.SELLER.name(), "Product Seller");
        createRoleIfNotExist(RoleName.CUSTOMER.name(), "Customer");
    }

    private void createRoleIfNotExist(String name, String description) {

        if (!roleRepository.existsByName(name)) {

            Role role = Role.builder()
                    .name(name)
                    .description(description)
                    .build();

            roleRepository.save(role);
        }
    }
}