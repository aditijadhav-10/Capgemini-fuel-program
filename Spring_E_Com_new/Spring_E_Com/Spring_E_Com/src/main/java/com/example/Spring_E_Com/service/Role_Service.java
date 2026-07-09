package com.example.Spring_E_Com.service;

import com.example.Spring_E_Com.dto.Role.RoleRequestDTO;
import com.example.Spring_E_Com.dto.Role.RoleResponseDTO;

import java.util.List;

public interface Role_Service {
    RoleResponseDTO createRole(RoleRequestDTO dto);
    RoleResponseDTO getRole(Long id);
    List<RoleResponseDTO>getAllRoles();
    RoleResponseDTO updateRole(Long id, RoleRequestDTO dto);
    void deleteRole(Long id);
}
