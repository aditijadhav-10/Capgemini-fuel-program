package com.example.Spring_E_Com.serviceImpl;

import com.example.Spring_E_Com.dto.role.RoleRequestDTO;
import com.example.Spring_E_Com.dto.role.RoleResponceDTO;
import com.example.Spring_E_Com.exception.ResourceNotFoundException;
import com.example.Spring_E_Com.model.Role;
import com.example.Spring_E_Com.repository.RoleRepository;
import com.example.Spring_E_Com.service.Role_Servies;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements Role_Servies {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public RoleResponceDTO createRole(RoleRequestDTO roleRequestDTO) {

        if(roleRepository.existsByName(roleRequestDTO.getName()))
        {
            throw  new ResourceNotFoundException("Role Alredy Present ");
        }
        Role role = modelMapper.map(roleRequestDTO, Role.class);
        Role savedRole = roleRepository.save(role);

        return modelMapper.map(savedRole, RoleResponceDTO.class);
    }

    @Override
    public RoleResponceDTO getData(Long id) {

        Role role = roleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Role not found with id : " + id));
        return modelMapper.map(role, RoleResponceDTO.class);
    }

    @Override
    public List<RoleResponceDTO> getAllRole() {

        List<Role> roles = roleRepository.findAll();

        return roles.stream()
                .map(role -> modelMapper.map(role, RoleResponceDTO.class))
                .toList();
    }

    @Override
    public RoleResponceDTO updateRoel(Long id, RoleRequestDTO roleRequestDTO) {

        Role role = roleRepository.findById(id).orElseThrow(() ->
                        new ResourceNotFoundException("Role not found with id : " + id));

        role.setName(roleRequestDTO.getName());
        role.setDescription(roleRequestDTO.getDescription());

        Role updatedRole = roleRepository.save(role);

        return modelMapper.map(updatedRole, RoleResponceDTO.class);
    }

    @Override
    public String deleteRole(Long id) {

        Role role = roleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Role not found with id : " + id));
        roleRepository.delete(role);
        return "Role deleted successfully with id : " + id;
    }
}