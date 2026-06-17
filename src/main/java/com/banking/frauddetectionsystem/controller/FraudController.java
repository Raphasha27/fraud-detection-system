package com.banking.frauddetectionsystem.controller;

import com.banking.frauddetectionsystem.model.*;
import com.banking.frauddetectionsystem.service.FraudDetectionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class FraudController {
    private final FraudDetectionService service;

    public FraudController(FraudDetectionService service) { this.service = service; }

    @PostMapping("/transactions")
    public ResponseEntity<Transaction> processTransaction(@RequestBody Map<String, Object> req) {
        return ResponseEntity.ok(service.processTransaction(
            (String)req.get("accountId"), (String)req.get("customerId"),
            new BigDecimal(req.get("amount").toString()), (String)req.get("type"),
            (String)req.get("sourceIp"), (String)req.get("location")));
    }

    @GetMapping("/alerts")
    public ResponseEntity<List<FraudAlert>> getAlerts(@RequestParam(required = false) String status) {
        return ResponseEntity.ok(service.getAlerts(status));
    }

    @PostMapping("/rules")
    public ResponseEntity<FraudRule> createRule(@RequestBody Map<String, String> req) {
        return ResponseEntity.ok(service.createRule(req.get("name"), req.get("description"), req.get("severity")));
    }

    @GetMapping("/rules")
    public ResponseEntity<List<FraudRule>> getRules() {
        return ResponseEntity.ok(service.getActiveRules());
    }

    @GetMapping("/health")
    public ResponseEntity<Map<String, String>> health() {
        return ResponseEntity.ok(Map.of("status", "UP", "service", "fraud-detection-system"));
    }
}
