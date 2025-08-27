package com.example.tickets.transactions.dto;

import com.example.tickets.transactions.util.TypeTransaction;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record TransactionRequest(

        @Min(1)
        @Positive
        @JsonProperty("acquire_funds_id")
        Long acquireFundsId,

        @NotNull
        @JsonProperty("document_user")
        String documentUser,

        @JsonProperty("transaction_type")
        TypeTransaction transactionType
) {
}
