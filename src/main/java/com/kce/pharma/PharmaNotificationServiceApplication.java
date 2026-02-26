package com.kce.pharma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.kce.pharma.client")
public class PharmaNotificationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PharmaNotificationServiceApplication.class, args);
    }
}
