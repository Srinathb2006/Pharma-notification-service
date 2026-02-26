package com.kce.pharma.client;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="inventory", url="${inventory.service.url}")
public interface InventoryClient {

    @GetMapping("/inventory/low-stock")
    List<Map<String,Object>> getLowStock();

    @GetMapping("/inventory/expiring")
    List<Map<String,Object>> getExpiring();
}
