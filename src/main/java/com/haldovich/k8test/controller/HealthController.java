package com.haldovich.k8test.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/actuator")
public class HealthController {

    @GetMapping("/health/startup")
    public ResponseEntity<String> startupHealthCheck() {
        return ResponseEntity.ok("Startup successful");
    }

    @GetMapping("/health/liveness")
    public ResponseEntity<String> livenessHealthCheck() {
        return ResponseEntity.ok("Application is running");
    }

    @GetMapping("/health/readiness")
    public ResponseEntity<String> readinessHealthCheck() {
        return ResponseEntity.ok("Application is ready");
    }
}
