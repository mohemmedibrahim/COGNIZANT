package com.cognizant.jwt.controller;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.jwt.model.AuthenticationResponse;
import com.cognizant.jwt.util.JwtUtil;

@RestController
public class AuthenticationController {

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/authenticate")
    public AuthenticationResponse authenticate(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader) {

        // Remove "Basic " from the Authorization header
        String base64Credentials = authorizationHeader.substring("Basic ".length());

        // Decode Base64 credentials
        byte[] decodedBytes = Base64.getDecoder().decode(base64Credentials);

        String credentials = new String(decodedBytes, StandardCharsets.UTF_8);

        // Split username and password
        String[] values = credentials.split(":", 2);

        String username = values[0];
        String password = values[1];

        // Generate JWT Token
        String token = jwtUtil.generateToken(username);

        // Return token as JSON
        return new AuthenticationResponse(token);
    }
}