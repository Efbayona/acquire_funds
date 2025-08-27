package com.example.tickets.transactions.service.impl;

import com.example.tickets.acquire_funds.entity.AcquireFunds;
import com.example.tickets.acquire_funds.service.AcquireFundsService;
import com.example.tickets.common.exception_handler.ConflictException;
import com.example.tickets.email.service.EmailSendService;
import com.example.tickets.transactions.dto.TransactionRequest;
import com.example.tickets.transactions.dto.TransactionResponse;
import com.example.tickets.transactions.entity.Transaction;
import com.example.tickets.transactions.repository.TransactionRepository;
import com.example.tickets.transactions.service.TransactionService;
import com.example.tickets.user.dto.UserResponse;
import com.example.tickets.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final UserService userService;
    private final AcquireFundsService acquireFundsService;
    private final EmailSendService emailSendService;

    public TransactionServiceImpl(TransactionRepository transactionRepository, UserService userService, AcquireFundsService acquireFundsService, EmailSendService emailSendService) {
        this.transactionRepository = transactionRepository;
        this.userService = userService;
        this.acquireFundsService = acquireFundsService;
        this.emailSendService = emailSendService;
    }

    @Override
    @Transactional
    public void processTransactionOpeningOrClosing(TransactionRequest request) {
        UserResponse userResponse = userService.getUserByDocument(request.documentUser());
        AcquireFunds acquireFunds = acquireFundsService.getAcquireFundsById(request.acquireFundsId());

        switch (request.transactionType()) {
            case OPENING ->
                    this.openTransaction(userResponse.amount(), acquireFunds.getMinimumAmount(), userResponse.documentNumber(), acquireFunds.getName(),userResponse.email());
            case CLOSING ->
                    this.closeTransaction(userResponse.amount(), acquireFunds.getMinimumAmount(), userResponse.documentNumber(),userResponse.email(), acquireFunds.getName());
        }

        transactionRepository.save(
                new Transaction(
                        acquireFunds.getAcquireFundsId(),
                        userResponse.documentNumber(),
                        request.transactionType().getValue()
                )
        );

        log.info("Transacción procesada exitosamente para el usuario con documento: [{}]", request);
    }

    @Override
    public List<TransactionResponse> getAllTransactions() {
        return transactionRepository.getAllTransactions();
    }

    private void openTransaction(Double userAmount, Double priceAcquireFunds, String documentUser, String fundName,String emailUser){
        if (userAmount < priceAcquireFunds) {
            throw new ConflictException("No tiene saldo disponible para vincularse al fondo " + fundName);
        }
        userService.updateUserAmount(documentUser, (userAmount - priceAcquireFunds));
        emailSendService.emailNotification(emailUser, "Se ha debitado de su cuenta la cantidad de " + priceAcquireFunds + " para vincularse al fondo " + fundName);
    }

    private void closeTransaction(Double userAmount, Double priceAcquireFunds, String documentUser,String emailUser,String fundName){
        userService.updateUserAmount(documentUser, (userAmount + priceAcquireFunds));
        emailSendService.emailNotification(emailUser, "Se ha acreditado en su cuenta la cantidad de " + priceAcquireFunds + " por desvincularse del fondo"+fundName);
    }
}
