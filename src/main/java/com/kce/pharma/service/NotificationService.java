package com.kce.pharma.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kce.pharma.entity.Notification;
import com.kce.pharma.repository.NotificationRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository repository;
    

    public NotificationService(NotificationRepository repository) {
		super();
		this.repository = repository;
	}

    public void create(String role, String title, String message) {

        Notification notification = new Notification();
        notification.setRole(role);
        notification.setTitle(title);
        notification.setMessage(message);
        notification.setRead(false);
        notification.setCreatedAt(java.time.LocalDateTime.now());

        repository.save(notification);
    }


    public List<Notification> getByRole(String role) {
        return repository.findByRoleOrderByCreatedAtDesc(role);
    }
    
    public void delete(String id) {
        repository.deleteById(id);
    }


    public void markAsRead(String id) {
        Notification n = repository.findById(id).orElseThrow();
        n.setRead(true);
        repository.save(n);
    }
}
