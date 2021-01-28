package com.beta.ms.auth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
@EnableCaching
@Slf4j
public class OAuthServiceApplication {
    public static void main (String[] args) {
        SpringApplication.run(OAuthServiceApplication.class, args);
    }
}
