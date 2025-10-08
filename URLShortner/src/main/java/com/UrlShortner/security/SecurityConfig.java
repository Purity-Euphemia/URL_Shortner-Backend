package com.UrlShortner.security;

import com.UrlShortner.service.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class SecurityConfig {
    private final JwtFilter jwtFilter;
    private final UserService userService;
    private final JwtUtil jwtUtil;

    public SecurityConfig(JwtFilter jwtFilter, UserService userService, JwtUtil jwtUtil) {
        this.jwtFilter = jwtFilter;
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, jakarta.servlet.ServletException {
        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);
            String username = jwtUtil.extractUsername(token);
    }
}
