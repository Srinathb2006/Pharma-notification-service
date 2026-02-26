package com.kce.pharma.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "notification_settings")
public class NotificationSettings {

    @Id
    private String id;

    private boolean lowStockEnabled;
    private boolean expiryEnabled;
    private boolean orderEnabled;
    private boolean dailyEnabled;

    private int lowStockLimit;
    private int expiryWarningDays;

   

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isLowStockEnabled() {
        return lowStockEnabled;
    }

    public void setLowStockEnabled(boolean lowStockEnabled) {
        this.lowStockEnabled = lowStockEnabled;
    }

    public boolean isExpiryEnabled() {
        return expiryEnabled;
    }

    public void setExpiryEnabled(boolean expiryEnabled) {
        this.expiryEnabled = expiryEnabled;
    }

    public boolean isOrderEnabled() {
        return orderEnabled;
    }

    public void setOrderEnabled(boolean orderEnabled) {
        this.orderEnabled = orderEnabled;
    }

    public boolean isDailyEnabled() {
        return dailyEnabled;
    }

    public void setDailyEnabled(boolean dailyEnabled) {
        this.dailyEnabled = dailyEnabled;
    }

    public int getLowStockLimit() {
        return lowStockLimit;
    }

    public void setLowStockLimit(int lowStockLimit) {
        this.lowStockLimit = lowStockLimit;
    }

    public int getExpiryWarningDays() {
        return expiryWarningDays;
    }

    public void setExpiryWarningDays(int expiryWarningDays) {
        this.expiryWarningDays = expiryWarningDays;
    }
}
