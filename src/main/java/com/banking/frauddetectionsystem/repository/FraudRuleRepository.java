package com.banking.frauddetectionsystem.repository;

import com.banking.frauddetectionsystem.model.FraudRule;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FraudRuleRepository extends JpaRepository<FraudRule, String> {
    List<FraudRule> findByActiveTrue();
}
