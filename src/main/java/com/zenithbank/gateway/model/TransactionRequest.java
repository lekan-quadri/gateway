package com.zenithbank.gateway.model;

import lombok.Data;

@Data
public class TransactionRequest {

    private String retailTransactionId;
    private String account;
    private String amount;
    private String transactionType;

}
