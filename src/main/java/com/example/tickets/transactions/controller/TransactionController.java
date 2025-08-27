package com.example.tickets.transactions.controller;

import com.example.tickets.transactions.dto.TransactionRequest;
import com.example.tickets.transactions.dto.TransactionResponse;
import com.example.tickets.transactions.service.TransactionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/")
    @Operation(description = "create transaction type open")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Transaction created"),
            @ApiResponse(responseCode = "404", description = "Not Found User or acquire funds"),
    })
    public ResponseEntity<HttpStatus> createTransactionOpenOrClosing(@Valid @RequestBody TransactionRequest request) {
        transactionService.processTransactionOpeningOrClosing(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/")
    @Operation(description = "Get all transactions")
    @ApiResponse(responseCode = "200", description = "Transaction created")
    public ResponseEntity<List<TransactionResponse>> getAllTransactions() {
        return new ResponseEntity<>(transactionService.getAllTransactions(), HttpStatus.OK);
    }
}
