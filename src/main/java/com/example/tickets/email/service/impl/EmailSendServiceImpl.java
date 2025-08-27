package com.example.tickets.email.service.impl;

import com.example.tickets.email.dto.EmailRequest;
import com.example.tickets.email.service.EmailSendService;
import com.example.tickets.email.service.EmailService;
import org.springframework.stereotype.Service;

@Service
public class EmailSendServiceImpl implements EmailSendService {

    private final EmailService emailService;

    public EmailSendServiceImpl(EmailService emailService) {
        this.emailService = emailService;
    }

    @Override
    public void emailNotification(String email,String message) {
        emailService.sendEmail(
                EmailRequest.create(
                        email,
                        "Notificación de Verificación",
                        message,
                        null,
                        null
                )
        );
    }
}
