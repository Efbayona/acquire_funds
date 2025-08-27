package com.example.tickets.transactions.repository;

import com.example.tickets.transactions.entity.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends MongoRepository<Transaction, String>,TransactionRepositoryCustom {

}
