package com.example.tickets.transactions.util;

import lombok.Getter;

@Getter
public enum TypeTransaction {
    CLOSING("Cierre"),
    OPENING("Apertura");

    private final String value;

    TypeTransaction(String value) {
        this.value = value;
    }

    public static TypeTransaction fromValue(String value) {
        return switch (value){
            case "Cierre" -> TypeTransaction.CLOSING;
            case "Apertura" -> TypeTransaction.OPENING;
            default -> throw new IllegalArgumentException("Terminal network [" + value + "] not supported.");
        };
    }
}
