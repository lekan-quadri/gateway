package com.zenithbank.gateway.controller;

import com.zenithbank.gateway.model.WebhookNotification;
import com.zenithbank.gateway.service.WebhookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/webhooks")
public class WebhookController {

    @Autowired
    private WebhookService webhookService;

    @PostMapping("/notifications")
    public ResponseEntity<Void> receiveNotification(@RequestBody WebhookNotification notification) {
        webhookService.processNotification(notification);
        return ResponseEntity.ok().build();
    }
}
