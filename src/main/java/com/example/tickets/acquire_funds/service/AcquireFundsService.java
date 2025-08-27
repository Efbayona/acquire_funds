package com.example.tickets.acquire_funds.service;

import com.example.tickets.acquire_funds.dto.AcquireFundsResponse;
import com.example.tickets.acquire_funds.entity.AcquireFunds;

import java.util.List;

public interface AcquireFundsService {
    List<AcquireFundsResponse> getAllAcquireFunds();

    AcquireFunds getAcquireFundsById(Long id);
}
