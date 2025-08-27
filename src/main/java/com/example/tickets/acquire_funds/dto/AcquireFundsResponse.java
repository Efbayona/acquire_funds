package com.example.tickets.acquire_funds.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AcquireFundsResponse(

        @JsonProperty("acquire_fund_id")
        Long acquireFundsId,

        @JsonProperty("name")
        String name,

        @JsonProperty("minimum_amount")
        Double minimumAmount,

        @JsonProperty("category")
        String category
) {
}
