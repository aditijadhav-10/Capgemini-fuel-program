package com.example.Spring_E_Com.controller;


import com.example.Spring_E_Com.dto.auth.LoginRequestDTO;
import com.example.Spring_E_Com.dto.auth.RegisterRequestDTO;
import com.example.Spring_E_Com.dto.auth.LoginResponseDTO;
import com.example.Spring_E_Com.dto.auth.RegisterResponceDTO;
import com.example.Spring_E_Com.serviceImpl.Auth_ServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class E_com_Controller {

    @Autowired
    private Auth_ServiceImpl e_com_serviceImpl;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponceDTO> saveRegidster(@Valid  @RequestBody RegisterRequestDTO registerRequestDTO) {

        RegisterResponceDTO saveRegister = e_com_serviceImpl.register(registerRequestDTO);

        return  ResponseEntity.status(HttpStatus.CREATED).body(saveRegister);
    }


//    @PostMapping("/login")
//    public ResponseEntity<LoginResponseDTO> saveLogin(@Valid @RequestBody LoginRequestDTO loginRequestDTO)
//    {
//        LoginResponseDTO saveLogin =e_com_serviceImpl.login(loginRequestDTO);
//        return  ResponseEntity.status(HttpStatus.ACCEPTED).body(saveLogin);
//    }


    @GetMapping("/{email}")
    public ResponseEntity<RegisterResponceDTO> getCustomer(@PathVariable String email) {

        return ResponseEntity.ok(e_com_serviceImpl.getRegisterData(email));
    }


//    @GetMapping
//    public ResponseEntity<List<Customer>> getAllCustomer() {
//
//        List<Customer> customers = customerService.getAllCustomers();
//
//        return ResponseEntity.ok(customers);
//    }




//    @PutMapping("/{id}")
//    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id,@RequestBody Customer customer)
//    {
//
//        Customer updatedCustomer = customerService.updateCustomer(id, customer);
//        return ResponseEntity.ok(updatedCustomer);
//    }




//    @DeleteMapping("/{id}")
//    public String deleteCustomer(@PathVariable Long id) {
//
//        e_com_serviceImpl.deleteCustomer(id);
//
//        return "Customer deleted successfully."+id;
//    }
}