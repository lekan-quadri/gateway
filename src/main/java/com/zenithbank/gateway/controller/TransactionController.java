package com.zenithbank.gateway.controller;

import com.zenithbank.gateway.model.Transaction;
import com.zenithbank.gateway.model.TransactionRequest;
import com.zenithbank.gateway.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<Transaction> initiateTransaction(@RequestBody TransactionRequest request) {
        Transaction transaction = transactionService.initiateTransaction(request);
        return ResponseEntity.ok(transaction);
    }

    @GetMapping("/{transactionId}")
    public ResponseEntity<Transaction> getTransactionStatus(@PathVariable String transactionId) {
        Transaction transaction = transactionService.getTransactionStatus(transactionId);
        return ResponseEntity.ok(transaction);
    }
}
