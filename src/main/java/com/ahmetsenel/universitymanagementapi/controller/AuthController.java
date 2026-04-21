package com.ahmetsenel.universitymanagementapi.controller;

import com.ahmetsenel.universitymanagementapi.common.ApiResponse;
import com.ahmetsenel.universitymanagementapi.dto.auth.AuthRequest;
import com.ahmetsenel.universitymanagementapi.dto.auth.AuthResponse;
import com.ahmetsenel.universitymanagementapi.dto.auth.RegisterRequest;
import com.ahmetsenel.universitymanagementapi.dto.auth.RegisterResponse;
import com.ahmetsenel.universitymanagementapi.service.impl.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController{

    private final AuthService authService;

    @PostMapping("/register")
    public ApiResponse<RegisterResponse> register(@Valid @RequestBody RegisterRequest registerRequest) {
        return ApiResponse.ok(authService.register(registerRequest));
    }

    @PostMapping("/login")
    public ApiResponse<AuthResponse> login(@RequestBody AuthRequest authRequest) {
        return ApiResponse.ok(authService.authenticate(authRequest));
    }
}
