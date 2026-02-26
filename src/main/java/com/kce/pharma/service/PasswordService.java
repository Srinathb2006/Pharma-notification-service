package com.kce.pharma.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.kce.pharma.client.AuthClient;
import com.kce.pharma.entity.PasswordResetRequest;
import com.kce.pharma.repository.PasswordResetRepository;



@Service

public class PasswordService {

    private final PasswordResetRepository repo;
    private final AuthClient authClient;
    private final EmailService emailService;

    public PasswordService(PasswordResetRepository repo, AuthClient authClient, EmailService emailService) {
		super();
		this.repo = repo;
		this.authClient = authClient;
		this.emailService = emailService;
	}

	public void request(String email) {
		PasswordResetRequest request = new PasswordResetRequest();
		request.setEmail(email);
		request.setApproved(false);
		request.setRequestedAt(LocalDateTime.now());

		repo.save(request);

    }

    public List<PasswordResetRequest> pending() {
        return repo.findByApprovedFalse();
    }

    public void approve(String email) {

        String newPassword = UUID.randomUUID()
                .toString().substring(0,8);

        authClient.resetPassword(email,newPassword);

        emailService.send(email,
                "Password Reset",
                "Your new password: "+newPassword);

        PasswordResetRequest r =
            repo.findByEmail(email);
        r.setApproved(true);
        repo.save(r);
    }
}
