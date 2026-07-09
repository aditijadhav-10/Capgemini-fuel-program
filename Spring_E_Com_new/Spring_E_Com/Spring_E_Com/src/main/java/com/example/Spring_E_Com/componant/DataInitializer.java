package com.example.Spring_E_Com.componant;

import com.example.Spring_E_Com.model.Role;
import com.example.Spring_E_Com.repository.RoleRepository;
import com.example.Spring_E_Com.role.RoleName;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final RoleRepository roleRepository;
    @Override
    public void run(String... args) throws Exception {
        createRoleIfNotExists(RoleName.ADMIN.name(),"System Administrator");
        createRoleIfNotExists(RoleName.SELLER.name(), "Product seller");
        createRoleIfNotExists(RoleName.CUSTOMER.name(), "Customer");



    }
    //helper
    private void createRoleIfNotExists(String name, String description){
        if(!roleRepository.existsByName(name)){
            roleRepository.save(Role.builder().name(name).description(description).build());
        }
    }


}

