package com.example.tickets.transactions.repository.impl;

import com.example.tickets.transactions.dto.TransactionResponse;
import com.example.tickets.transactions.repository.TransactionRepositoryCustom;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;

import java.util.List;

public class TransactionRepositoryCustomImpl implements TransactionRepositoryCustom {

    private final MongoTemplate mongoTemplate;

    public TransactionRepositoryCustomImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }


    @Override
    public List<TransactionResponse> getAllTransactions() {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.lookup("users", "documentNumber", "documentNumber", "user"),
                Aggregation.lookup("acquire_funds", "acquireFundsId", "acquireFundsId", "fund"),
                Aggregation.unwind("user",true),
                Aggregation.unwind("fund",true),
                Aggregation.project("transactionType", "transactionIdentifier", "user", "fund")
                        .and("user.name").as("userName")
                        .and("user.lastName").as("lastName")
                        .and("user.documentNumber").as("documentNumber")
                        .and("fund.name").as("nameAcquiredFund")
                        .and("fund.minimumAmount").as("minimumAmount")
                        .and("fund.category").as("category")
                        .and("fund.acquireFundsId").as("acquireFundsId")
        );

        AggregationResults<TransactionResponse> results = mongoTemplate.aggregate(aggregation, "transactions", TransactionResponse.class);
        return results.getMappedResults();
    }
}
