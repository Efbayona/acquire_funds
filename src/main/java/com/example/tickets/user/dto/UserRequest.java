package com.example.tickets.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record UserRequest(

        @NotBlank
        @JsonProperty("name")
        String name,

        @NotBlank
        @JsonProperty("lastName")
        String lastName,

        @Email
        @JsonProperty("email")
        String email,

        @NotBlank
        @JsonProperty("document_number")
        String documentNumber,

        @NotBlank
        @JsonProperty("phone_number")
        String phoneNumber,

        @Positive
        @DecimalMin(value = "500")
        @JsonProperty("amount")
        Double amount
) {
}
