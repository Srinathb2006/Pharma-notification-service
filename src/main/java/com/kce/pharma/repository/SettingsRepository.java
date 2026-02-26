package com.kce.pharma.repository;

import com.kce.pharma.entity.NotificationSettings;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SettingsRepository
        extends MongoRepository<NotificationSettings, String> {
}
