package com.example.Spring_E_Com.controller;

import com.example.Spring_E_Com.dto.Role.RoleRequestDTO;
import com.example.Spring_E_Com.dto.Role.RoleResponseDTO;
import com.example.Spring_E_Com.service.Role_Service;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    @Autowired
    private Role_Service roleService;

    // Create Role
    @PostMapping
    public ResponseEntity<RoleResponseDTO> createRole(@Valid @RequestBody RoleRequestDTO dto) {

        RoleResponseDTO response = roleService.createRole(dto);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // Get Role By Id
    @GetMapping("/{id}")
    public ResponseEntity<RoleResponseDTO> getRole(@PathVariable Long id) {

        RoleResponseDTO response = roleService.getRole(id);

        return ResponseEntity.ok(response);
    }

    // Get All Roles
    @GetMapping
    public ResponseEntity<List<RoleResponseDTO>> getAllRoles() {

        List<RoleResponseDTO> response = roleService.getAllRoles();

        return ResponseEntity.ok(response);
    }

    // Update Role
    @PutMapping("/{id}")
    public ResponseEntity<RoleResponseDTO> updateRole(
            @PathVariable Long id,
            @Valid @RequestBody RoleRequestDTO dto) {

        RoleResponseDTO response = roleService.updateRole(id, dto);

        return ResponseEntity.ok(response);
    }

    // Delete Role
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRole(@PathVariable Long id) {

        roleService.deleteRole(id);

        return ResponseEntity.ok("Role deleted successfully.");
    }
}