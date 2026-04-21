package com.ahmetsenel.universitymanagementapi.dto.auth;

import lombok.Data;

@Data
public class AuthRequest {

    private String username;

    private String password;
}
