package com.example.tickets.email.service;

import com.example.tickets.email.dto.EmailRequest;

public interface EmailService {
    void sendEmail(EmailRequest request);
}
