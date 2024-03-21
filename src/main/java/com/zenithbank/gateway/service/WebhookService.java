package com.zenithbank.gateway.service;

import com.zenithbank.gateway.model.WebhookNotification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebhookService {

    @Autowired
    private TransactionService service;

    public void processNotification(WebhookNotification notification) {
        service.updateTransaction(notification);
    }
}
