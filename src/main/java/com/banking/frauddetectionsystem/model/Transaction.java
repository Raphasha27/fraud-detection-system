package com.banking.frauddetectionsystem.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity @Table(name = "transactions")
public class Transaction {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String accountId;
    private String customerId;
    private BigDecimal amount;
    private String currency;
    private String type;
    private String sourceIp;
    private String location;
    private String status;
    private LocalDateTime timestamp;

    public Transaction() {}
    public Transaction(String accountId, String customerId, BigDecimal amount, String type, String sourceIp, String location) {
        this.accountId = accountId; this.customerId = customerId; this.amount = amount;
        this.type = type; this.sourceIp = sourceIp; this.location = location;
        this.status = "PENDING"; this.timestamp = LocalDateTime.now();
    }
    public String getId() { return id; }
    public String getAccountId() { return accountId; }
    public String getCustomerId() { return customerId; }
    public BigDecimal getAmount() { return amount; }
    public String getCurrency() { return currency; }
    public String getType() { return type; }
    public String getSourceIp() { return sourceIp; }
    public String getLocation() { return location; }
    public String getStatus() { return status; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public void setStatus(String s) { this.status = s; }
    public void setCurrency(String c) { this.currency = c; }
}
