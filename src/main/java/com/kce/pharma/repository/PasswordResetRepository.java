package com.kce.pharma.repository;

import com.kce.pharma.entity.PasswordResetRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PasswordResetRepository
        extends MongoRepository<PasswordResetRequest, String> {

    List<PasswordResetRequest> findByApprovedFalse();

    PasswordResetRequest findByEmail(String email);
}
