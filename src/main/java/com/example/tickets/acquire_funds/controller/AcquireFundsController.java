package com.example.tickets.acquire_funds.controller;

import com.example.tickets.acquire_funds.dto.AcquireFundsResponse;
import com.example.tickets.acquire_funds.service.AcquireFundsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/acquire-funds")
public class AcquireFundsController {

    private final AcquireFundsService acquireFundsService;

    public AcquireFundsController(AcquireFundsService acquireFundsService) {
        this.acquireFundsService = acquireFundsService;
    }

    @GetMapping("/")
    @Operation(description = "Get all acquire funds options")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved list")
    public ResponseEntity<List<AcquireFundsResponse>> getAllAcquireFunds() {
        return ResponseEntity.ok(acquireFundsService.getAllAcquireFunds());
    }
}
