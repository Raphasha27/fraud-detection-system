package com.banking.frauddetectionsystem.service;

import com.banking.frauddetectionsystem.model.*;
import com.banking.frauddetectionsystem.repository.*;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class FraudDetectionService {
    private final TransactionRepository transactionRepo;
    private final FraudRuleRepository ruleRepo;
    private final FraudAlertRepository alertRepo;

    public FraudDetectionService(TransactionRepository tr, FraudRuleRepository rr, FraudAlertRepository ar) {
        this.transactionRepo = tr; this.ruleRepo = rr; this.alertRepo = ar;
    }

    public Transaction processTransaction(String accountId, String customerId, BigDecimal amount,
                                           String type, String sourceIp, String location) {
        Transaction txn = new Transaction(accountId, customerId, amount, type, sourceIp, location);
        txn = transactionRepo.save(txn);

        List<FraudRule> rules = ruleRepo.findByActiveTrue();
        for (FraudRule rule : rules) {
            if (rule.getThresholdAmount() != null && amount.compareTo(rule.getThresholdAmount()) > 0) {
                FraudAlert alert = new FraudAlert(txn.getId(), accountId, rule.getName(), rule.getSeverity(),
                    "Transaction amount " + amount + " exceeds threshold " + rule.getThresholdAmount());
                alertRepo.save(alert);
                txn.setStatus("FLAGGED");
                transactionRepo.save(txn);
            }
        }

        LocalDateTime oneMinuteAgo = LocalDateTime.now().minusMinutes(1);
        List<Transaction> recent = transactionRepo.findByAccountIdAndTimestampAfter(accountId, oneMinuteAgo);
        if (recent.size() > 5) {
            FraudAlert alert = new FraudAlert(txn.getId(), accountId, "RAPID_TRANSACTIONS", "HIGH",
                "Account " + accountId + " has " + recent.size() + " transactions in 1 minute");
            alertRepo.save(alert);
            txn.setStatus("FLAGGED");
            transactionRepo.save(txn);
        }

        if (!"FLAGGED".equals(txn.getStatus())) {
            txn.setStatus("CLEARED");
            transactionRepo.save(txn);
        }
        return txn;
    }

    public List<FraudAlert> getAlerts(String status) {
        return status != null ? alertRepo.findByStatus(status) : alertRepo.findAll();
    }

    public FraudRule createRule(String name, String description, String severity) {
        return ruleRepo.save(new FraudRule(name, description, severity));
    }

    public List<FraudRule> getActiveRules() { return ruleRepo.findByActiveTrue(); }
}
