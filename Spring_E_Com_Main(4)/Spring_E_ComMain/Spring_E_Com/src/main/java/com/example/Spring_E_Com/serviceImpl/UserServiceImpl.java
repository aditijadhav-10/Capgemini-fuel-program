package com.example.Spring_E_Com.serviceImpl;

import com.example.Spring_E_Com.dto.auth.AuthResponseDTO;
import com.example.Spring_E_Com.dto.auth.RegisterRequestDTO;
import com.example.Spring_E_Com.exception.ResourceNotFoundException;
import com.example.Spring_E_Com.model.User;
import com.example.Spring_E_Com.repository.RoleRepository;
import com.example.Spring_E_Com.repository.UserRepository;
import com.example.Spring_E_Com.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
//@AllArgsConstructor
//@NoArgsConstructor
@Service
public class UserServiceImpl implements UserService {
//
//    private final UserRepository userRepository;
//    private final RoleRepository roleRepository;
//    private final PasswordEncoder passwordEncoder;
//    private final ModelMapper modelMapper;
//    private final EmailServiceImpl emailService;
//
//    @Override
//    public AuthResponseDTO getRegisterData(String email) {
//
//        User user = userRepository.findByEmail(email.trim().toLowerCase())
//                .orElseThrow(() -> new ResourceNotFoundException("User not found."));
//
//        return modelMapper.map(user, AuthResponseDTO.class);
//    }
//
//    @Override
//    public String deleteUser(Long id) {
//
//        User user = userRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("User not found."));
//
//        userRepository.delete(user);
//
//        return "User deleted successfully. ID: " + id;
//    }
//
//    @Override
//    public AuthResponseDTO updateUser(Long id, RegisterRequestDTO dto) {
//
//        User user = userRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("User not found."));
//
//        user.setFirstName(dto.getFirstName().trim());
//        user.setLastName(dto.getLastName().trim());
//        user.setEmail(dto.getEmail().trim().toLowerCase());
//        user.setPhone(dto.getPhone().trim());
//
//        if (dto.getPassword() != null && !dto.getPassword().isBlank()) {
//            user.setPassword(passwordEncoder.encode(dto.getPassword().trim()));
//        }
//
//        User updatedUser = userRepository.save(user);
//
//        return modelMapper.map(updatedUser, AuthResponseDTO.class);
//    }
//
//    @Override
//    public List<User> getAllCustomers() {
//        return userRepository.findAll();
//    }
}
