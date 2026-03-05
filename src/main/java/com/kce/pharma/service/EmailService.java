package com.kce.pharma.service;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class EmailService {

```
private static final String BREVO_API_URL = "https://api.brevo.com/v3/smtp/email";
private static final String API_KEY = System.getenv("BREVO_API_KEY");

public void send(String to, String subject, String body) {

    try {

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("api-key", API_KEY);

        Map<String, Object> request = Map.of(
                "sender", Map.of(
                        "name", "PharmaCare",
                        "email", "sbrinath479@gmail.com"
                ),
                "to", new Object[]{
                        Map.of("email", to)
                },
                "subject", subject,
                "textContent", body
        );

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(request, headers);

        restTemplate.postForEntity(BREVO_API_URL, entity, String.class);

        System.out.println("=================================");
        System.out.println("EMAIL SENT SUCCESSFULLY USING BREVO API");
        System.out.println("To: " + to);
        System.out.println("=================================");

    } catch (Exception e) {

        System.err.println("FAILED TO SEND EMAIL: " + e.getMessage());
        System.out.println("=================================");
        System.out.println("FALLBACK - EMAIL CONTENT LOGGED BELOW:");
        System.out.println("To: " + to);
        System.out.println("Subject: " + subject);
        System.out.println("Body: " + body);
        System.out.println("=================================");

    }
}
```

}
