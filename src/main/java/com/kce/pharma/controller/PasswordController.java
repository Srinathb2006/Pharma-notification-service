package com.kce.pharma.controller;

import com.kce.pharma.entity.PasswordResetRequest;
import com.kce.pharma.service.PasswordService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/password")
@RequiredArgsConstructor
public class PasswordController {

    public PasswordController(PasswordService passwordService) {
		super();
		this.passwordService = passwordService;
	}

	private final PasswordService passwordService;

    // User clicks forgot password
    @PostMapping("/request")
    public void request(@RequestParam String email) {
        passwordService.request(email);
    }

    // Admin fetch pending requests
    @GetMapping("/pending")
    @PreAuthorize("hasRole('ADMIN')")
    public List<PasswordResetRequest> pending() {
        return passwordService.pending();
    }

    // Admin approves reset
    @PostMapping("/approve")
    @PreAuthorize("hasRole('ADMIN')")
    public void approve(@RequestParam String email) {
        passwordService.approve(email);
    }
}
