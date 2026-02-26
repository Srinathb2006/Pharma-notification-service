package com.kce.pharma.client;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="billing", url="${billing.service.url}")
public interface BillingClient {

    @GetMapping("/purchase-orders/pending")
    List<Map<String,Object>> getPendingPayments();
}
