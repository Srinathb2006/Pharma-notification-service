package com.kce.pharma.service;

import org.springframework.stereotype.Service;
import com.kce.pharma.entity.NotificationSettings;
import com.kce.pharma.repository.SettingsRepository;

@Service
public class SettingsService {

    private final SettingsRepository repository;

    public SettingsService(SettingsRepository repository) {
        this.repository = repository;
    }

    public NotificationSettings getSettings() {
        return repository.findAll()
                .stream()
                .findFirst()
                .orElseGet(() -> {
                    NotificationSettings settings = new NotificationSettings();
                    settings.setLowStockLimit(50);
                    settings.setExpiryWarningDays(90);
                    settings.setLowStockEnabled(true);
                    settings.setExpiryEnabled(true);
                    settings.setOrderEnabled(true);
                    settings.setDailyEnabled(false);
                    return repository.save(settings);
                });
    }

    public NotificationSettings save(NotificationSettings settings) {
        repository.deleteAll(); // keep only one settings document
        return repository.save(settings);
    }
}
