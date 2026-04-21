package com.ahmetsenel.universitymanagementapi.service.impl;

import com.ahmetsenel.universitymanagementapi.dto.auth.AuthRequest;
import com.ahmetsenel.universitymanagementapi.dto.auth.AuthResponse;
import com.ahmetsenel.universitymanagementapi.dto.auth.RegisterRequest;
import com.ahmetsenel.universitymanagementapi.dto.auth.RegisterResponse;
import com.ahmetsenel.universitymanagementapi.entity.User;
import com.ahmetsenel.universitymanagementapi.entity.enums.Role;
import com.ahmetsenel.universitymanagementapi.exception.BaseException;
import com.ahmetsenel.universitymanagementapi.exception.MessageType;
import com.ahmetsenel.universitymanagementapi.repository.UserRepository;
import com.ahmetsenel.universitymanagementapi.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @Transactional
    public RegisterResponse register(RegisterRequest registerRequest) {
        User createdUser = createUser(registerRequest);

        RegisterResponse registerResponse = new RegisterResponse();
        registerResponse.setUsername(createdUser.getUsername());
        return registerResponse;
    }

    public AuthResponse authenticate(AuthRequest authRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequest.getUsername(),
                        authRequest.getPassword()
                )
        );

        User user = userRepository.findUserByUsername(authRequest.getUsername())
                .orElseThrow(() -> new BaseException(MessageType.USER_NOT_FOUND));

        String token = jwtUtil.generateToken(user);

        return new AuthResponse(token);
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new BaseException(MessageType.USER_NOT_FOUND));
    }

    private User createUser(RegisterRequest request) {
        if (userRepository.findUserByUsername(request.getUsername()).isPresent()) {
            throw new BaseException(MessageType.USERNAME_ALREADY_EXIST, request.getUsername());
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.ROLE_USER);
        return userRepository.save(user);
    }
}
