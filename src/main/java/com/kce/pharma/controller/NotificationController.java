
package com.kce.pharma.controller;

import com.kce.pharma.entity.Notification;
import com.kce.pharma.service.NotificationService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notifications")

public class NotificationController {

    private final NotificationService notificationService;
    

    public NotificationController(NotificationService notificationService) {
		super();
		this.notificationService = notificationService;
	}

	// Get notifications by role
    @GetMapping("/{role}")
    public List<Notification> getByRole(@PathVariable String role) {
        return notificationService.getByRole(role);
    }

    // Mark notification as read
    @PatchMapping("/{id}/read")
    public void markAsRead(@PathVariable String id) {
        notificationService.markAsRead(id);
    }

    // Delete notification
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        notificationService.delete(id);
    }
}
