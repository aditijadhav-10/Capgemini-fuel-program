package com.example.Spring_E_Com.controller;
import com.example.Spring_E_Com.dto.auth.AuthResponseDTO;
import com.example.Spring_E_Com.dto.auth.LoginRequestDTO;
import com.example.Spring_E_Com.dto.auth.RegisterRequestDTO;
import com.example.Spring_E_Com.model.User;
import com.example.Spring_E_Com.serviceImpl.AuthServiceImpl;
import com.example.Spring_E_Com.serviceImpl.EmailServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("users")
public class Auth_Controller {

    @Autowired
    private AuthServiceImpl authService;

    @Autowired
    private EmailServiceImpl emailService;

    // For the User
    @PostMapping("/register")
    public ResponseEntity<AuthResponseDTO> saveRegidster(@Valid  @RequestBody RegisterRequestDTO registerRequestDTO)
    {
        AuthResponseDTO saveRegister = authService.register(registerRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveRegister);

    }

    // for the login
    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> saveLogin(@Valid @RequestBody LoginRequestDTO loginRequestDTO) {
        AuthResponseDTO saveLogin = authService.login(loginRequestDTO);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(saveLogin);

    }

//    @GetMapping("/{email}")
//    public ResponseEntity<AuthResponseDTO> getCustomer(@PathVariable String email)
//    {
//        return ResponseEntity.ok(authService.getRegisterData(email));
//    }

//
//    @GetMapping
//    public ResponseEntity<List<User>> getAllCustomer()
//    {
//        List<User> customers = authService.getAllCustomers();
//        return ResponseEntity.ok(customers);
//    }


//    @DeleteMapping("/{id}")
//    public String deleteCustomer(@PathVariable Long id)
//    {
//        authService.deleteUser(id);
//        return "User deleted successfully."+id;
//    }

}