package com.example.tickets.acquire_funds.service.impl;

import com.example.tickets.acquire_funds.dto.AcquireFundsResponse;
import com.example.tickets.acquire_funds.entity.AcquireFunds;
import com.example.tickets.acquire_funds.repository.AcquireFundsRepository;
import com.example.tickets.acquire_funds.service.AcquireFundsService;
import com.example.tickets.common.exception_handler.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AcquireFundsServiceImpl implements AcquireFundsService {

    private final AcquireFundsRepository acquireFundsRepository;

    public AcquireFundsServiceImpl(AcquireFundsRepository acquireFundsRepository) {
        this.acquireFundsRepository = acquireFundsRepository;
    }

    @Override
    public List<AcquireFundsResponse> getAllAcquireFunds() {
        return acquireFundsRepository.findAll()
                .stream()
                .map(acquireFunds -> new AcquireFundsResponse(
                        acquireFunds.getAcquireFundsId(),
                        acquireFunds.getName(),
                        acquireFunds.getMinimumAmount(),
                        acquireFunds.getCategory()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public AcquireFunds getAcquireFundsById(Long id) {
        return acquireFundsRepository.findByAcquireFundsId(id).orElseThrow(() -> new ResourceNotFoundException("el fondo solicitado no existe"));
    }
}
