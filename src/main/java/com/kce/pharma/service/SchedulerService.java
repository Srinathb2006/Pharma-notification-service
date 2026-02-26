package com.kce.pharma.service;

import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.kce.pharma.client.BillingClient;
import com.kce.pharma.client.InventoryClient;
import com.kce.pharma.entity.NotificationSettings;
import com.kce.pharma.repository.SettingsRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SchedulerService {

    private final InventoryClient inventoryClient;
    private final BillingClient billingClient;
    private final NotificationService notificationService;
    private final SettingsRepository settingsRepo;

    public SchedulerService(InventoryClient inventoryClient, BillingClient billingClient,
			NotificationService notificationService, SettingsRepository settingsRepo) {
		super();
		this.inventoryClient = inventoryClient;
		this.billingClient = billingClient;
		this.notificationService = notificationService;
		this.settingsRepo = settingsRepo;
	}

	@Scheduled(cron = "0 0 */6 * * *")
    public void checkAlerts() {

        NotificationSettings settings =
                settingsRepo.findAll().stream().findFirst().orElse(null);

        if (settings == null) return;

        if (settings.isLowStockEnabled()) {
            inventoryClient.getLowStock().forEach(item ->
                notifyAllRoles("Low Stock",
                    item.get("name")+" stock is low"));
        }

        if (settings.isExpiryEnabled()) {
            inventoryClient.getExpiring().forEach(item ->
                notifyAllRoles("Expiry Alert",
                    item.get("name")+" expiring soon"));
        }

        if (settings.isOrderEnabled()) {
            billingClient.getPendingPayments().forEach(po ->
                notifyAdminInventory("Pending Payment",
                    "PO "+po.get("poId")+" unpaid"));
        }
    }

    private void notifyAllRoles(String title, String message) {
        List.of("ADMIN","PHARMACIST","INVENTORY","MANAGER")
            .forEach(role -> notificationService.create(role,title,message));
    }

    private void notifyAdminInventory(String title, String message) {
        List.of("ADMIN","INVENTORY")
            .forEach(role -> notificationService.create(role,title,message));
    }
}
