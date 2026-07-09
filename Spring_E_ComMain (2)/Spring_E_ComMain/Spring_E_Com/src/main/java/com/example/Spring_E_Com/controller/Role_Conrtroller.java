package com.example.Spring_E_Com.controller;

import com.example.Spring_E_Com.dto.role.RoleRequestDTO;
import com.example.Spring_E_Com.dto.role.RoleResponceDTO;
import com.example.Spring_E_Com.serviceImpl.Role_ServiceImpl;
import jakarta.validation.Valid;
import org.hibernate.internal.build.AllowPrintStacktrace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

public class Role_Conrtroller {


    @Autowired
    private Role_ServiceImpl roleService;

    @PostMapping
    public RoleResponceDTO create(@Valid @RequestBody RoleRequestDTO roleRequestDTO)
    {
        return roleService.createRole(roleRequestDTO);
    }

    @GetMapping("/{id}")
    public RoleResponceDTO get(@PathVariable Long id)
    {
        return roleService.getData(id);
    }

//    @GetMapping
//    public RoleResponseDTO getAll(@PathVariable String name ) {
//        return roleService.getAllRole(name);


    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id)
    {
        roleService.deleteRole(id);
        return "The Role is deleted Successfully .. "+id;

    }

    @PutMapping("/{id}")
    public RoleResponceDTO update(@Valid @RequestBody RoleRequestDTO roleRequestDTO,@PathVariable Long id)
    {
        return null;
    }
}
