package com.example.tickets.acquire_funds.entity;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Document("acquire_funds")
public class AcquireFunds {
    @Id
    private String _id;

    private Long acquireFundsId;

    private String name;

    private Double minimumAmount;

    private String category;
}
