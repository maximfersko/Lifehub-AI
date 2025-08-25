package com.lifehub.gateway.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class MockController {

    @GetMapping("/auth/**")
    public ResponseEntity<Map<String, Object>> authEndpoint(@RequestHeader(value = "X-User-ID", required = false) String userId) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Auth endpoint reached via Gateway");
        response.put("service", "gateway-mock");
        response.put("userId", userId);
        response.put("status", "success");
        response.put("token", "mock-jwt-token-" + System.currentTimeMillis());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/auth/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody Map<String, String> loginRequest) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Login endpoint reached via Gateway");
        response.put("service", "gateway-mock");
        response.put("status", "success");
        response.put("token", "mock-jwt-token-" + System.currentTimeMillis());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/auth/register")
    public ResponseEntity<Map<String, Object>> register(@RequestBody Map<String, String> registerRequest) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Register endpoint reached via Gateway");
        response.put("service", "gateway-mock");
        response.put("status", "success");
        response.put("userId", "user-" + System.currentTimeMillis());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/news/**")
    public ResponseEntity<Map<String, Object>> newsEndpoint(@RequestHeader(value = "X-User-ID", required = false) String userId) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "News endpoint reached via Gateway");
        response.put("service", "gateway-mock");
        response.put("userId", userId);
        response.put("news", new String[]{"News 1", "News 2", "News 3"});
        return ResponseEntity.ok(response);
    }

    @GetMapping("/goals/**")
    public ResponseEntity<Map<String, Object>> goalsEndpoint(@RequestHeader(value = "X-User-ID", required = false) String userId) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Goals endpoint reached via Gateway");
        response.put("service", "gateway-mock");
        response.put("userId", userId);
        response.put("goals", new String[]{"Goal 1", "Goal 2", "Goal 3"});
        return ResponseEntity.ok(response);
    }

    @GetMapping("/tasks/**")
    public ResponseEntity<Map<String, Object>> tasksEndpoint(@RequestHeader(value = "X-User-ID", required = false) String userId) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Tasks endpoint reached via Gateway");
        response.put("service", "gateway-mock");
        response.put("userId", userId);
        response.put("tasks", new String[]{"Task 1", "Task 2", "Task 3"});
        return ResponseEntity.ok(response);
    }

    @GetMapping("/health")
    public ResponseEntity<Map<String, Object>> health() {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "UP");
        response.put("service", "gateway-mock");
        response.put("timestamp", System.currentTimeMillis());
        return ResponseEntity.ok(response);
    }
}
