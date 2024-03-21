package com.zenithbank.gateway.service;

import com.zenithbank.gateway.model.Transaction;
import com.zenithbank.gateway.model.TransactionRequest;
import com.zenithbank.gateway.model.WebhookNotification;
import com.zenithbank.gateway.repository.TransactionRepository;
import com.zenithbank.gateway.util.ReferenceGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository repository;

    public Transaction initiateTransaction(TransactionRequest request) {

        Transaction transaction = new Transaction();
        transaction.setRetailTransactionId(request.getRetailTransactionId());
        transaction.setAmount(request.getAmount());
        transaction.setAccount(request.getAccount());
        transaction.setTransactionReference(ReferenceGenerator.generateType1UUID().toString());

/**
 * if timeout then pending
 * Status - 01-Pending, 00-Successful, 99-Failed
 */
        transaction = postTransaction(transaction);

        return repository.save(transaction);
    }

    public Transaction getTransactionStatus(String transactionId) {
        return repository.findByRetailTransactionId(transactionId);
    }

    public void updateTransaction(WebhookNotification notification) {
        SimpleDateFormat sdf = new SimpleDateFormat("");

        Transaction transaction = repository.findByRetailTransactionId(notification.getTransactionReference());
        transaction.setResponseCode(notification.getResponseCode());
        transaction.setResponseDescription(notification.getResponseDescription());
        try {
            transaction.setResponseTime(sdf.parse(notification.getResponseTime()));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        repository.save(transaction);
    }

    public Transaction postTransaction(Transaction transaction) {

        transaction.setResponseCode("00");
        transaction.setResponseTime(new Date());
        transaction.setResponseDescription("Successful");
        return transaction;
    }
}
