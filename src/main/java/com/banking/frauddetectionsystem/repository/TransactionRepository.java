package com.banking.frauddetectionsystem.repository;

import com.banking.frauddetectionsystem.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, String> {
    List<Transaction> findByAccountIdAndTimestampAfter(String accountId, LocalDateTime after);
    List<Transaction> findByStatus(String status);
}
