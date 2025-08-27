package com.example.tickets.user.repository;

import com.example.tickets.user.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    Boolean existsByEmailIgnoreCase(String email);

    Boolean existsByDocumentNumber(String documentNumber);

    Optional<User> findByDocumentNumber(String documentNumber);
}
