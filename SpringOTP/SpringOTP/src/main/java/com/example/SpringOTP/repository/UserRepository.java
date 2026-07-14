package com.example.SpringOTP.repository;

import java.util.Optional;

import com.example.SpringOTP.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Find user by email
    Optional<User> findByEmail(String email);

    // Check whether email already exists
    boolean existsByEmail(String email);

    // Find user by email and OTP (used during verification)
    Optional<User> findByEmailAndOtp(String email, String otp);
}