package com.banking.frauddetectionsystem.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity @Table(name = "fraud_rules")
public class FraudRule {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String description;
    private String severity; // LOW, MEDIUM, HIGH, CRITICAL
    private BigDecimal thresholdAmount;
    private int maxTransactionsPerMinute;
    private boolean active;

    public FraudRule() {}
    public FraudRule(String name, String description, String severity) {
        this.name = name; this.description = description; this.severity = severity; this.active = true;
    }
    public String getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getSeverity() { return severity; }
    public BigDecimal getThresholdAmount() { return thresholdAmount; }
    public int getMaxTransactionsPerMinute() { return maxTransactionsPerMinute; }
    public boolean isActive() { return active; }
    public void setThresholdAmount(BigDecimal t) { this.thresholdAmount = t; }
    public void setMaxTransactionsPerMinute(int m) { this.maxTransactionsPerMinute = m; }
}
