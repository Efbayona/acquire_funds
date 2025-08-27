package com.example.tickets.transactions.service;

import com.example.tickets.transactions.dto.TransactionRequest;
import com.example.tickets.transactions.dto.TransactionResponse;

import java.util.List;

public interface TransactionService {
    void processTransactionOpeningOrClosing(TransactionRequest request);

    List<TransactionResponse> getAllTransactions();
}
