package com.ahmetsenel.universitymanagementapi.security;

import com.ahmetsenel.universitymanagementapi.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SecurityService {

    public Long getCurrentUserId() {
        return ((User)
                SecurityContextHolder.getContext()
                        .getAuthentication()
                        .getPrincipal())
                .getId();
    }
}
