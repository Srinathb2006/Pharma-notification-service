package com.kce.pharma.repository;

import com.kce.pharma.entity.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface NotificationRepository
        extends MongoRepository<Notification, String> {

    List<Notification> findByRoleOrderByCreatedAtDesc(String role);
}
