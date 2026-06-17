package com.banking.frauddetectionsystem.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity @Table(name = "fraud_alerts")
public class FraudAlert {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String transactionId;
    private String accountId;
    private String ruleTriggered;
    private String severity;
    private String status = "NEW";
    private String description;
    private LocalDateTime detectedAt;

    public FraudAlert() {}
    public FraudAlert(String transactionId, String accountId, String ruleTriggered, String severity, String desc) {
        this.transactionId = transactionId; this.accountId = accountId;
        this.ruleTriggered = ruleTriggered; this.severity = severity;
        this.description = desc; this.detectedAt = LocalDateTime.now();
    }
    public String getId() { return id; }
    public String getTransactionId() { return transactionId; }
    public String getAccountId() { return accountId; }
    public String getRuleTriggered() { return ruleTriggered; }
    public String getSeverity() { return severity; }
    public String getStatus() { return status; }
    public String getDescription() { return description; }
    public LocalDateTime getDetectedAt() { return detectedAt; }
    public void setStatus(String s) { this.status = s; }
}
