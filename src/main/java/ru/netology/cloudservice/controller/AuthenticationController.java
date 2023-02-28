package ru.netology.cloudservice.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.netology.cloudservice.service.AuthenticationService;
import ru.netology.cloudservice.web.request.AuthRequest;
import ru.netology.cloudservice.web.response.AuthResponse;


//todo тесты интеграция и юнит
//todo документации к классам и методам



@Slf4j
@RestController
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;


    @PostMapping("/register")
    public ResponseEntity<?>register(@RequestBody AuthRequest request) {
        return authenticationService.register(request);
    }


    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        log.info("Authentication is successfully");
        return authenticationService.login(request);

    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestHeader("auth-token") String authToken) {
        authenticationService.logout(authToken);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
