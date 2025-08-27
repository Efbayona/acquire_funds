package com.example.tickets.acquire_funds.repository;

import com.example.tickets.acquire_funds.entity.AcquireFunds;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AcquireFundsRepository extends MongoRepository<AcquireFunds,String> {
    Optional<AcquireFunds> findByAcquireFundsId(Long id);
}
