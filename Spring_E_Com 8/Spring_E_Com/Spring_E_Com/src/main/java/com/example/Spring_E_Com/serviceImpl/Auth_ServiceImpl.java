package com.example.Spring_E_Com.serviceImpl;
import com.example.Spring_E_Com.dto.auth.LoginRequestDTO;
import com.example.Spring_E_Com.dto.auth.RegisterRequestDTO;
import com.example.Spring_E_Com.dto.auth.LoginResponseDTO;
import com.example.Spring_E_Com.dto.auth.RegisterResponceDTO;
import com.example.Spring_E_Com.exception.UserNotFoundException;
import com.example.Spring_E_Com.model.Role;
import com.example.Spring_E_Com.model.User;
import com.example.Spring_E_Com.repository.RoleRepository;
import com.example.Spring_E_Com.repository.UserRepository;
import com.example.Spring_E_Com.service.Auth_Service;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Auth_ServiceImpl implements Auth_Service {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public RegisterResponceDTO register(RegisterRequestDTO registerRequestDTO) {

        registerRequestDTO.setPassword(registerRequestDTO.getPassword().trim());

        User user = modelMapper.map(registerRequestDTO, User.class);

        user.setPassword(passwordEncoder.encode(registerRequestDTO.getPassword()));

        Role customerRole = roleRepository.findByName("Customer")
                .orElseThrow(() -> new UserNotFoundException("Customer not found"));

        user.setRole(customerRole);

        User saveRegistration = userRepository.save(user);

        return modelMapper.map(saveRegistration, RegisterResponceDTO.class);
    }

    @Override
    public RegisterResponceDTO getRegisterData(String email)
    {
        Optional<User> user = userRepository.findByEmail(email);
        RegisterResponceDTO dto=modelMapper.map(user,RegisterResponceDTO.class);
        return dto;
    }

    @Override
    public String deleteUser(Long id) {
        return "";
    }

//
//    @Override
//    public LoginResponseDTO login(LoginRequestDTO loginRequestDTO) {
//
//        User user = userRepository.findByEmail(loginRequestDTO.getEmail())
//                .orElseThrow(() -> new UserNotFoundException("Sorry Invalid Email --- user not found "));
//        if (!passwordEncoder.matches(loginRequestDTO.getPassword(), user.getPassword()))
//        {
//            throw new UserNotFoundException("sorry invalid password   --- please try agian --- ");
//        }
//
//        LoginResponseDTO response = new LoginResponseDTO();
//        response.setEmail(user.getEmail());
//        response.setPassword(user.getPassword());
//        response.setRole(user.getRole().name());
//
//        return response;
//    }

//    @Override
//    public String deleteUser(Long id) {
//
//        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User Not Found Here "));
//        userRepository.delete(user);
//        return " ------ User Deleted Successfully --------  : "+id;
//    }


//
//
//    @Override
//    public Customer updateCustomer(Long id, Customer customer) {
//
//        Customer exitingCus = customerRepository.findById(id).orElseThrow();
//
//        exitingCus.setFirstName(customer.getFirstName());
//        exitingCus.setLastName(customer.getLastName());
//        exitingCus.setEmail(customer.getEmail());
//        exitingCus.setPassword(customer.getPassword());
//        exitingCus.setPhone(customer.getPhone());
//
//        exitingCus.setGender(customer.getGender());
//        exitingCus.setRating(customer.getRating());
//
//        return customerRepository.save(exitingCus);
//
//    }





//    @Override
//    public Customer getCustomerById(Long id) {
//
//        return customerRepository.findById(id).orElseThrow();
//    }




//    @Override
//    public List<Customer> getAllCustomers() {
//
//        return customerRepository.findAll();
//    }
//






}