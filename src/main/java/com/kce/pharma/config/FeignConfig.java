package com.kce.pharma.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.context.SecurityContextHolder;

@Configuration
public class FeignConfig {

    @Bean
    public RequestInterceptor requestInterceptor() {
        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate template) {

                var auth = SecurityContextHolder.getContext().getAuthentication();

                if (auth != null && auth.getCredentials() != null) {
                    template.header("Authorization",
                            "Bearer " + auth.getCredentials().toString());
                }
            }
        };
    }
}
