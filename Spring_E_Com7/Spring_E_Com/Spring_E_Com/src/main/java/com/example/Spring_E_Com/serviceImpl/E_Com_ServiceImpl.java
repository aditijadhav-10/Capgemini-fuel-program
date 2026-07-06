package com.example.Spring_E_Com.serviceImpl;
import com.example.Spring_E_Com.dto.request.LoginRequestDTO;
import com.example.Spring_E_Com.dto.request.RegisterRequestDTO;
import com.example.Spring_E_Com.dto.response.LoginResponseDTO;
import com.example.Spring_E_Com.dto.response.RegisterResponceDTO;
import com.example.Spring_E_Com.exception.UserNotFoundException;
import com.example.Spring_E_Com.model.User;
import com.example.Spring_E_Com.repository.RoleRepository;
import com.example.Spring_E_Com.repository.UserRepository;
import com.example.Spring_E_Com.role.Role;
import com.example.Spring_E_Com.service.E_Com_Service;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class E_Com_ServiceImpl implements E_Com_Service {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public RegisterResponceDTO register(RegisterRequestDTO registerRequestDTO) {

        registerRequestDTO.setPassword(registerRequestDTO.getPassword().trim());

        User user = modelMapper.map(registerRequestDTO, User.class);

        user.setPassword(passwordEncoder.encode(registerRequestDTO.getPassword()));

//user.setRole(Role.ROLE_customer);

        User saveRegistration = userRepository.save(user);

        Role customerRole= roleRepository.findRoleBy("CUSTOMER").orElseThrow(()->new UserNotFoundException("customer not found"));
        user.setRole(customerRole);

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
    public LoginResponseDTO login(LoginRequestDTO loginRequestDTO) {

        User user = userRepository.findByEmail(loginRequestDTO.getEmail())
                .orElseThrow(() -> new UserNotFoundException("Sorry Invalid Email --- user not found "));
        if (!passwordEncoder.matches(loginRequestDTO.getPassword(), user.getPassword()))
        {
            throw new UserNotFoundException("sorry invalid password   --- please try agian --- ");
        }

        LoginResponseDTO response = new LoginResponseDTO();
        response.setEmail(user.getEmail());
        response.setPassword(user.getPassword());
        response.setRole(user.getRole().name());

        return response;
    }



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


//
//    @Override
//    public String deleteCustomer(Long id) {
//
//        Customer customer = customerRepository.findById(id).orElseThrow();
//        customerRepository.delete(customer);
//        return " ------ Customer Deleted Successfully -------- "+id;
//    }


}