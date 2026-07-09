package com.example.Spring_E_Com.serviceImpl;

import com.example.Spring_E_Com.constants.AppConstants;
import com.example.Spring_E_Com.dto.auth.AuthResponseDTO;
import com.example.Spring_E_Com.dto.auth.LoginRequestDTO;
import com.example.Spring_E_Com.dto.auth.RegisterRequestDTO;
import com.example.Spring_E_Com.exception.ResourceNotFound;
import com.example.Spring_E_Com.model.Role;
import com.example.Spring_E_Com.model.User;
import com.example.Spring_E_Com.repository.RoleRepository;
import com.example.Spring_E_Com.repository.UserRepository;
import com.example.Spring_E_Com.role.RoleName;
import com.example.Spring_E_Com.service.Auth_Service;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;

@AllArgsConstructor
@Service
public class Auth_ServiceImpl implements Auth_Service {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;
    private final EmailServiceImpl emailService;

    @Override
    public AuthResponseDTO register(RegisterRequestDTO registerRequestDTO) {

        registerRequestDTO.setFirstName(registerRequestDTO.getFirstName().trim());
        registerRequestDTO.setLastName(registerRequestDTO.getLastName().trim());
        registerRequestDTO.setEmail(registerRequestDTO.getEmail().trim().toLowerCase());
        registerRequestDTO.setPassword(registerRequestDTO.getPassword().trim());
        registerRequestDTO.setPhone(registerRequestDTO.getPhone().trim());

        User user = modelMapper.map(registerRequestDTO, User.class);

        user.setPassword(passwordEncoder.encode(registerRequestDTO.getPassword()));

        Role customerRole = roleRepository.findByName(RoleName.CUSTOMER.name())
                .orElseThrow(() -> new ResolutionException("Customer role not found"));

        user.setRole(customerRole);

        User savedUser = userRepository.save(user);

        emailService.sendRegisterEmail(savedUser.getEmail(), savedUser.getFirstName());

        return AuthResponseDTO.builder()
                .id(savedUser.getId())
                .firstName(savedUser.getFirstName())
                .lastName(savedUser.getLastName())
                .email(savedUser.getEmail())
                .role(savedUser.getRole().getName())
                .message(AppConstants.REGISTER_SUCCESS)
                .build();
    }

    @Override
    public AuthResponseDTO login(LoginRequestDTO loginRequestDTO) {

        User user = userRepository.findByEmail(loginRequestDTO.getEmail().trim().toLowerCase())
                .orElseThrow(() -> new ResourceNotFound("Invalid Email"));

        if (!passwordEncoder.matches(loginRequestDTO.getPassword(), user.getPassword())) {
            throw new ResourceNotFound("Invalid Password");
        }

        emailService.sendLoginEmail(user.getEmail(), user.getRole().getName());

        return AuthResponseDTO.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .role(user.getRole().getName())
                .message(AppConstants.LOGIN_SUCCESS)
                .build();
    }
}