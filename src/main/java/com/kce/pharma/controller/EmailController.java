package com.kce.pharma.controller;

import com.kce.pharma.dto.EmailRequest;
import org.springframework.web.bind.annotation.*;

import com.kce.pharma.service.EmailService;

@RestController
@RequestMapping("/email")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/send")
    public void send(@RequestBody EmailRequest request) {
        emailService.send(request.getTo(), request.getSubject(), request.getBody());
    }
}
