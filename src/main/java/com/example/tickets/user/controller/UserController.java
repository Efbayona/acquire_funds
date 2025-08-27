package com.example.tickets.user.controller;

import com.example.tickets.user.dto.UserRequest;
import com.example.tickets.user.dto.UserResponse;
import com.example.tickets.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/")
    @Operation(description = "create user")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "User created"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "409", description = "Conflict: Email already exists")
    })
    public ResponseEntity<HttpStatus> createUser(@Valid @RequestBody UserRequest request) {
        userService.createUser(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{document}")
    @Operation(description = "create user")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "User created"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "409", description = "Conflict: Email already exists")
    })
    public ResponseEntity<UserResponse> getUserByDocument(@PathVariable("document") String document) {
        return new ResponseEntity<>(userService.getUserByDocument(document),HttpStatus.OK);
    }
}
