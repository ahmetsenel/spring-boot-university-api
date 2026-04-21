package com.ahmetsenel.universitymanagementapi.handler;

import com.ahmetsenel.universitymanagementapi.common.ApiError;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;

@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void handle(HttpServletRequest request,
                       HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws IOException {

        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.setContentType("application/json");

        ApiError<String> apiError = new ApiError<>();
        apiError.setStatus(HttpServletResponse.SC_FORBIDDEN);
        apiError.setPath(request.getRequestURI());
        apiError.setTimestamp(LocalDateTime.now().toString());
        apiError.setMessage("Access denied");

        response.getWriter().write(objectMapper.writeValueAsString(apiError));
    }
}
