package com.akbar.onlineshop.auth.controller;

import com.akbar.onlineshop.auth.dto.*;
import com.akbar.onlineshop.auth.service.AuthService;
import com.akbar.onlineshop.commons.dto.RegisterDto;
import com.akbar.onlineshop.commons.dto.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/auth")
@Slf4j
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterDto registerDto) {
        log.info("Register..");
        registerDto.setId(UUID.randomUUID().toString());
        registerDto.setPassword(BCrypt.hashpw(registerDto.getPassword(),BCrypt.gensalt()));

        ResponseDto responseDto = authService.register(registerDto);
        HttpStatus status = responseDto.getStatus().equalsIgnoreCase("1") ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;

        return new ResponseEntity<>(responseDto,status);
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody CredentialsDto credentialsDto) {
        log.info("Login..");
        return ResponseEntity.ok(authService.login(credentialsDto));
    }

    @PostMapping("/validateToken")
    public ResponseEntity<User> validateToken(@RequestParam String token) {
        log.info("Validate token..");
        return ResponseEntity.ok(authService.validateToken(token));
    }
}
