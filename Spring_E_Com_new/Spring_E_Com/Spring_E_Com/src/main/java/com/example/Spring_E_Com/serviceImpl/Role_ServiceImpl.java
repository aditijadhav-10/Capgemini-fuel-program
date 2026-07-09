package com.example.Spring_E_Com.serviceImpl;

import com.example.Spring_E_Com.dto.Role.RoleRequestDTO;
import com.example.Spring_E_Com.dto.Role.RoleResponseDTO;
import com.example.Spring_E_Com.dto.product.ProductResponseDTO;
import com.example.Spring_E_Com.exception.ProductNotFoundException;
import com.example.Spring_E_Com.exception.RoleNotFoundException;
import com.example.Spring_E_Com.model.Product;
import com.example.Spring_E_Com.model.Role;
import com.example.Spring_E_Com.repository.RoleRepository;
import com.example.Spring_E_Com.service.Role_Service;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Role_ServiceImpl implements Role_Service {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public RoleResponseDTO createRole(RoleRequestDTO dto) {
        Role role=modelMapper.map(dto,Role.class);
        Role savedProduct =roleRepository.save(role);
        return modelMapper.map(savedProduct, RoleResponseDTO.class);
    }

    @Override
    public RoleResponseDTO getRole(Long id) {
        Role role=roleRepository.findById(id).orElseThrow(()->new RoleNotFoundException("Role not found"));
        RoleResponseDTO dto=modelMapper.map(role,RoleResponseDTO.class);
        return dto;
    }

    @Override
    public List<RoleResponseDTO> getAllRoles() {
        return List.of();
    }

    @Override
    public RoleResponseDTO updateRole(Long id, RoleRequestDTO dto) {
        Role role=roleRepository.findById(id).orElseThrow(()->new RoleNotFoundException("Role not found"));
        RoleResponseDTO dto1=modelMapper.map(role,RoleResponseDTO.class);
        Role updateRole=roleRepository.save(role);
        return modelMapper.map(updateRole, RoleResponseDTO.class);


    }

    @Override
    public void deleteRole(Long id) {
        Role role = roleRepository.findById(id).orElseThrow(() -> new RoleNotFoundException("Role deleted" + id));
        roleRepository.delete(role);

    }
}
