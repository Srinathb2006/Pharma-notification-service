package com.kce.pharma.controller;

import org.springframework.web.bind.annotation.*;
import com.kce.pharma.entity.NotificationSettings;
import com.kce.pharma.service.SettingsService;

@RestController
@RequestMapping("/settings")
public class SettingsController {

    private final SettingsService service;

    public SettingsController(SettingsService service) {
        this.service = service;
    }

    @GetMapping
    public NotificationSettings get() {
        return service.getSettings();
    }

    @PutMapping
    public NotificationSettings update(@RequestBody NotificationSettings settings) {
        return service.save(settings);
    }
}
