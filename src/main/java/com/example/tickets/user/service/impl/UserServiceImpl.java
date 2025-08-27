package com.example.tickets.user.service.impl;

import com.example.tickets.common.exception_handler.ConflictException;
import com.example.tickets.common.exception_handler.ResourceNotFoundException;
import com.example.tickets.user.dto.UserRequest;
import com.example.tickets.user.dto.UserResponse;
import com.example.tickets.user.entity.User;
import com.example.tickets.user.repository.UserRepository;
import com.example.tickets.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(UserRequest request) {

        if (userRepository.existsByDocumentNumber(request.documentNumber())) {
            throw new ConflictException("documento ya se encuentra registrado, por favor busque su usuario");
        }

        if (userRepository.existsByEmailIgnoreCase(request.email())) {
            throw new ConflictException("email ya se encuentra registrado");
        }

        userRepository.save(
                new User(
                        request.name(),
                        request.lastName(),
                        request.email(),
                        request.documentNumber(),
                        request.phoneNumber(),
                        request.amount()
                )
        );
        log.info("Usuario creado exitosamente con documento: [{}]", request.documentNumber());
    }

    @Override
    public UserResponse getUserByDocument(String document) {
        return userRepository.findByDocumentNumber(document).map(user -> new UserResponse(
                user.get_id(),
                user.getName(),
                user.getLastName(),
                user.getEmail(),
                user.getDocumentNumber(),
                user.getPhoneNumber(),
                user.getAmount()
        )).orElseThrow(() -> new ResourceNotFoundException("El usuario con documento " + document + " no existe"));
    }

    @Override
    public void updateUserAmount(String document, Double updateAmount) {
        User user = userRepository.findByDocumentNumber(document).get();
        user.updateAmount(updateAmount);
        userRepository.save(user);
    }
}
