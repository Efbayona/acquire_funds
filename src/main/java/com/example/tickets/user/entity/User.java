package com.example.tickets.user.entity;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Document("users")
public class User {
    @Id
    private String _id;

    private String name;

    private String lastName;

    @Indexed(unique = true)
    private String email;

    private String documentNumber;

    private String phoneNumber;

    private Double amount;

    public User(String name, String lastName, String email, String documentNumber, String phoneNumber, Double amount) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.documentNumber = documentNumber;
        this.phoneNumber = phoneNumber;
        this.amount = amount;
    }

    public void updateAmount(Double amount) {
        this.amount = amount;
    }
}
