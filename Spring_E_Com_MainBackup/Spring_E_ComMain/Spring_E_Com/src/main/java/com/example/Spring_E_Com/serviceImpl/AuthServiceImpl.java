package com.example.Spring_E_Com.serviceImpl;

import com.example.Spring_E_Com.constants.AppConstant;
import com.example.Spring_E_Com.constants.ErrorMessages;
import com.example.Spring_E_Com.constants.SuccessMessages;
import com.example.Spring_E_Com.dto.auth.AuthResponseDTO;
import com.example.Spring_E_Com.dto.auth.LoginRequestDTO;
import com.example.Spring_E_Com.dto.auth.RegisterRequestDTO;
import com.example.Spring_E_Com.exception.ResourceNotFoundException;
import com.example.Spring_E_Com.exception.UnauthorisedException;
import com.example.Spring_E_Com.model.Role;
import com.example.Spring_E_Com.model.User;
import com.example.Spring_E_Com.repository.RoleRepository;
import com.example.Spring_E_Com.repository.UserRepository;
import com.example.Spring_E_Com.role.RoleName;
import com.example.Spring_E_Com.service.Auth_Service;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements Auth_Service {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final EmailServiceImpl emailService;


    @Transactional
    @Override
    public AuthResponseDTO register(RegisterRequestDTO registerRequestDTO) {
//1
        String firstName = normalizeText(registerRequestDTO.getFirstName());
        String lastName = normalizeText(registerRequestDTO.getLastName());

        String email = normalizeEmail(registerRequestDTO.getEmail());

        String rawpassword = normalizeText(registerRequestDTO.getPassword());
        String phone = normalizeText(registerRequestDTO.getPhone());
//2
        registerRequestDTO.setFirstName(firstName);
        registerRequestDTO.setLastName(lastName);
        registerRequestDTO.setEmail(email);
        registerRequestDTO.setPassword(enocodePassowrd(rawpassword));
        registerRequestDTO.setPhone(phone);

        if (userRepository.existsByEmail(email)) {
            throw new ResourceNotFoundException(ErrorMessages.EMAIL_ALREADY_EXISTS);
        }
//3
        Role customerRole = roleRepository.findByName(RoleName.CUSTOMER.name())
                .orElseThrow(() ->
                        new ResourceNotFoundException(ErrorMessages.ROLE_NOT_FOUND));
//4
        User user = User.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .phone(phone)
                .password(passwordEncoder.encode(rawpassword))
                .isActive(true)
                .emailVerified(false)
                .accountNonLoacked(true)
                .role(customerRole)
                .build();
//5
        User savedUser = userRepository.save(user);
//6
        emailService.sendRegisterEmail(
                savedUser.getEmail(),
                savedUser.getFirstName()
        );
//7
        return buildAuthResponse(user, SuccessMessages.REGSITRATION_SUCCESSFUL);
    }

    @Transactional(readOnly = true)
    @Override
    public AuthResponseDTO login(LoginRequestDTO loginRequestDTO) {

        //1 Normalize input
        String email = normalizeEmail(loginRequestDTO.getEmail());
        String rawPassword = normalizeText(loginRequestDTO.getPassword());
        //2 Find user by email
        User user = findUserEmail(email);

        //3 Check password
        boolean passwordMatches = passwordEncoder.matches(rawPassword, user.getPassword());
        if (!passwordMatches) {
            throw new UnauthorisedException(ErrorMessages.INVALID_EMAIL_OR_PASSWORD);
        }
        //4 Send login email
        emailService.sendLoginEmail(
                user.getEmail(),
                user.getFirstName()
        );
        //5 calling the validate user for login insted of the verify some componants
        validateUserFroLogin(user,rawPassword);
        return buildAuthResponse(user,SuccessMessages.LOGIN_SUCCESSFUL);
    }

    private Boolean active=true;
    private Boolean emailVerified=false;
    private Boolean accountNonLocked=true;


    // -------------  Here We Creating The Helper Method For The Code Optimization --------------------

    //for the email removing the wid spaces and convert it into the lowaer case
    private String normalizeEmail(String email) {
        return email.trim().toLowerCase();
    }


    //for the text removing the wide spaces
    private String normalizeText(String value) {
        return value.trim();
    }


    //for the text removing the wide spaces
    private String enocodePassowrd(String value) {
        return value.trim();
    }

    //Helper Method for the return the meassge and data
    private AuthResponseDTO buildAuthResponse(User user, String message) {

        return AuthResponseDTO.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .role(user.getRole().getName())
                .message(message)
                .build();
    }


    //
    private void validateUserFroLogin(User user,String meaasge)
    {
        // here we can checked where the email is varified or not
//        if (!user.getEmailVerified()) {
//            throw new UnauthorisedException(ErrorMessages.EMAIL_NOT_VERIFIED);
//        }

        //Check account is active
        if (!user.getIsActive()) {
            throw new UnauthorisedException(ErrorMessages.ACCOUNT_DISABLED);
        }

        //check whether the account is loacked or not
        if(!user.getAccountNonLoacked())
        {
            throw  new UnauthorisedException(ErrorMessages.ACCOUNT_LOCKED);
        }
    }

    // here we are created the helper method  for finding the email(cheking email present or not)
    private  User findUserEmail(String email)
    {
        return userRepository.findByEmail(email).orElseThrow(()-> new UnauthorisedException(ErrorMessages.INVALID_EMAIL_OR_PASSWORD));
    }
}

