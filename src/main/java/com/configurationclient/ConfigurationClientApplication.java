package com.configurationclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableFeignClients
@EnableScheduling
public class ConfigurationClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigurationClientApplication.class, args);
    }
}
