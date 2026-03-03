package com.kce.pharma.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void send(String to, String subject, String body) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(to);
            message.setSubject(subject);
            message.setText(body);

            mailSender.send(message);

            System.out.println("=================================");
            System.out.println("REAL EMAIL SENT SUCCESSFULLY");
            System.out.println("To: " + to);
            System.out.println("=================================");
        } catch (Exception e) {
            System.err.println("FAILED TO SEND REAL EMAIL: " + e.getMessage());
            System.out.println("=================================");
            System.out.println("FALLBACK - EMAIL CONTENT LOGGED BELOW:");
            System.out.println("To: " + to);
            System.out.println("Subject: " + subject);
            System.out.println("Body: " + body);
            System.out.println("=================================");
        }
    }
}