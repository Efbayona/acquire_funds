package com.example.tickets.transactions.repository;

import com.example.tickets.transactions.dto.TransactionResponse;

import java.util.List;

public interface TransactionRepositoryCustom {
    List<TransactionResponse> getAllTransactions();
}
