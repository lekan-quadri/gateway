package com.zenithbank.gateway.model;

import lombok.Data;

@Data
public class WebhookNotification {

    private String transactionReference;
    private String responseTime;
    private String responseCode;
    private String responseDescription;
}
