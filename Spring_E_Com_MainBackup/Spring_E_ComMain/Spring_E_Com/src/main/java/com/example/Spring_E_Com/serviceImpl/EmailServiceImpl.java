package com.example.Spring_E_Com.serviceImpl;

import com.example.Spring_E_Com.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender mailSender;

    @Override
    public boolean sendRegisterEmail(String to, String name) {

        SimpleMailMessage message = new SimpleMailMessage();

        // Optional
        // message.setFrom("pradeeptaware081@gmail.com");

        message.setTo(to);
        message.setSubject("Welcome to E-Commerce");

        message.setText("""
                Dear %s,

                🎉 Congratulations!

                Your account has been created successfully, and we're excited to welcome you to our E-Commerce platform.

                You can now:
                • Browse thousands of products
                • Add items to your cart
                • Place orders securely
                • Track your orders in real-time
                • Manage your profile and account settings

                Thank you for choosing us. We look forward to providing you with an amazing shopping experience!

                If you have any questions or need assistance, feel free to contact our support team.

                Happy Shopping! 🛍️

                Best Regards,
                E-Commerce Team
                """.formatted(name));

        mailSender.send(message);
        return true;
    }

    @Override
    public boolean sendLoginEmail(String to, String role) {

        SimpleMailMessage message = new SimpleMailMessage();

        // Optional
        // message.setFrom("pradeeptaware081@gmail.com");

        message.setTo(to);
        message.setSubject("Login Successful - E-Commerce");

        message.setText("""
                Dear Customer,

                We noticed a successful login to your E-Commerce account.

                Login Details:
                ---------------------------------
                Email : %s
                Role  : %s
                Status: Login Successful
                ---------------------------------

                If this was you, no further action is required.

                If you do not recognize this login, please change your password immediately and contact our support team.

                Thank you for shopping with us!

                Best Regards,
                E-Commerce Team
                """.formatted(to, role));

        mailSender.send(message);
        return true;
    }
}