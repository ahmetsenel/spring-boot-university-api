package com.ahmetsenel.universitymanagementapi.handler;

import com.ahmetsenel.universitymanagementapi.common.ApiError;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;

@Component
public class AuthEntryPointImpl implements AuthenticationEntryPoint {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException {

        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json");

        ApiError<String> apiError = new ApiError<>();
        apiError.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        apiError.setPath(request.getRequestURI());
        apiError.setTimestamp(LocalDateTime.now().toString());
        apiError.setMessage("Unauthorized - wrong credentials");

        response.getWriter().write(objectMapper.writeValueAsString(apiError));
    }
}
