package com.zenithbank.gateway.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String retailTransactionId;
    @JsonIgnore
    private String account;
    @JsonIgnore
    private String amount;
    private String responseDescription;
    private String responseCode;
    @JsonIgnore
    private Date responseTime;
    private String transactionReference;

}
