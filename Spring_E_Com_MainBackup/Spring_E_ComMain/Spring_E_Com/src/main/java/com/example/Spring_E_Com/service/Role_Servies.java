package com.example.Spring_E_Com.service;

import com.example.Spring_E_Com.dto.role.RoleRequestDTO;
import com.example.Spring_E_Com.dto.role.RoleResponceDTO;
import com.example.Spring_E_Com.repository.RoleRepository;

import java.util.List;

public interface Role_Servies {


    RoleResponceDTO createRole(RoleRequestDTO dto);
    RoleResponceDTO getData(Long id);
    List<RoleResponceDTO> getAllRole();
    RoleResponceDTO updateRoel(Long id, RoleRequestDTO roleRequestDTO);
    String deleteRole(Long id);
}
