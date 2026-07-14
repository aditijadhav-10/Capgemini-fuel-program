package com.example.Spring_E_Com.serviceImpl;

import com.example.Spring_E_Com.security.jwt.JwtService;
import org.springframework.security.core.Authentication;
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
import com.example.Spring_E_Com.security.UserPrincipal;
import com.example.Spring_E_Com.service.Auth_Service;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements Auth_Service {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;
    private ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final EmailServiceImpl emailService;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;


    @Transactional
    @Override
    public AuthResponseDTO register(RegisterRequestDTO registerRequestDTO) {

        // 1. Normalize input
        String firstName = normalizeText(registerRequestDTO.getFirstName());
        String lastName = normalizeText(registerRequestDTO.getLastName());
        String email = normalizeEmail(registerRequestDTO.getEmail());
        String rawPassword = normalizeText(registerRequestDTO.getPassword());
        String phone = normalizeText(registerRequestDTO.getPhone());

        // 2. Check if email already exists
        if (userRepository.existsByEmail(email)) {
            throw new ResourceNotFoundException(ErrorMessages.EMAIL_ALREADY_EXISTS);
        }

        // 3. Get CUSTOMER role
        Role customerRole = roleRepository.findByName(RoleName.CUSTOMER.name())
                .orElseThrow(() ->
                        new ResourceNotFoundException(ErrorMessages.ROLE_NOT_FOUND));

        // 4. Encode password
        String encodedPassword = passwordEncoder.encode(rawPassword);

        // 5. Create User
        User user = User.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .phone(phone)
                .password(encodedPassword)
                .isActive(true)
                .emailVerified(false)
                .accountNonLoacked(true)
                .accountNonExpired(true)
                .credentialNonExpired(true)
                .role(customerRole)
                .build();

        // 6. Save User
        User savedUser = userRepository.save(user);

        // 7. Generate JWT Token
        UserPrincipal userPrincipal = new UserPrincipal(savedUser);

        String token = jwtService.generateToken(userPrincipal);

        // 8. Save Token (Optional)
        savedUser.setToken(token);
        userRepository.save(savedUser);

        // 9. Send Email (Optional)
        emailService.sendRegisterEmail(savedUser.getEmail(), savedUser.getFirstName());


        // 10. Return response
        return buildAuthResponse(savedUser, SuccessMessages.REGSITRATION_SUCCESSFUL);
    }

    @Transactional(readOnly = true)
    @Override
    public AuthResponseDTO login(LoginRequestDTO loginRequestDTO) {

        // 1. Normalize input
        String email = normalizeEmail(loginRequestDTO.getEmail());
        String rawPassword = normalizeText(loginRequestDTO.getPassword());

        // 2. Authenticate user
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, rawPassword)
        );

        // 3. Get authenticated user
        UserPrincipal principal = (UserPrincipal) authentication.getPrincipal();
        User user = principal.getUser();

        // 4. (Optional) Send login notification email
        // emailService.sendLoginEmail(user.getEmail(), user.getFirstName());

        // 5. Build and return response
        return buildAuthResponse(user, SuccessMessages.LOGIN_SUCCESSFUL);
    }

    private Boolean active=true;
    private Boolean emailVerified=false;
    private Boolean accountNonLocked=true;


    // -------------  Here We Creating The Helper Method For The Code Optimization --------------------

    //for the email removing the wide spaces and convert it into the lower case

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
                .token(user.getToken())
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