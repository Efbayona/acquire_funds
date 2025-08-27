package com.example.tickets.transactions.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.UUID;

@Getter
@Document("transactions")
public class Transaction {

    @Id
    private String _id;

    private Long acquireFundsId;

    private String documentNumber;

    private String transactionType;

    private UUID transactionIdentifier;

    @CreatedDate
    private Instant createdAt;

    public Transaction(Long acquireFundsId, String documentNumber, String transactionType) {
        this.acquireFundsId = acquireFundsId;
        this.documentNumber = documentNumber;
        this.transactionType = transactionType;
        this.transactionIdentifier = UUID.randomUUID();
    }
}
