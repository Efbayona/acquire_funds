package com.example.tickets.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UserResponse(

        @JsonProperty("_id")
        String _id,

        @JsonProperty
        String name,

        @JsonProperty("lastName")
        String lastName,

        @JsonProperty("email")
        String email,

        @JsonProperty("document_number")
        String documentNumber,

        @JsonProperty("phone_number")
        String phoneNumber,

        @JsonProperty("amount")
        Double amount
) {
}
