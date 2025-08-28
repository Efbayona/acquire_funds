package com.example.tickets.transactions.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public record TransactionResponse(
        @JsonProperty("transaction_type")
        String transactionType,

        @JsonProperty("transaction_identifier")
        UUID transactionIdentifier,

        @JsonProperty("user_name")
        String userName,

        @JsonProperty("last_name")
        String lastName,

        @JsonProperty("document_number")
        String documentNumber,

        @JsonProperty("name_acquired_fund")
        String nameAcquiredFund,

        @JsonProperty("minimum_amount")
        Double minimumAmount,

        @JsonProperty("category")
        String category,

        @JsonProperty("acquire_funds_id")
        String acquireFundsId
) {
}
