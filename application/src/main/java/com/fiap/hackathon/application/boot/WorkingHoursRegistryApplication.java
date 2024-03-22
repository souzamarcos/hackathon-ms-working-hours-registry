package com.fiap.hackathon.application.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.fiap.hackathon")
public class WorkingHoursRegistryApplication {
    public static void main(String[] args) {
        SpringApplication.run(WorkingHoursRegistryApplication.class, args);
    }
}
