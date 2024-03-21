package com.zenithbank.gateway.repository;

import com.zenithbank.gateway.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    Transaction findByRetailTransactionId(String retailReferenceId);
}
