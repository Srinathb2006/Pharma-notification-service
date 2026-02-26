package com.kce.pharma.client;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="auth", url="${auth.service.url}")
public interface AuthClient {

    @PutMapping("/users/reset-password")
    void resetPassword(@RequestParam String email,
                       @RequestParam String newPassword);

    @GetMapping("/users/email/{email}")
    Map<String,Object> getUser(@PathVariable String email);
}

