package com.example.tickets.user.service;

import com.example.tickets.user.dto.UserRequest;
import com.example.tickets.user.dto.UserResponse;

public interface UserService {
    void createUser(UserRequest request);
    UserResponse getUserByDocument(String document);
    void updateUserAmount(String document,Double updateAmount);
}
