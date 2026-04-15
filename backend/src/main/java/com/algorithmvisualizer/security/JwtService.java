package com.algorithmvisualizer.security;

import org.springframework.stereotype.Service;

@Service
public class JwtService {
    
    // Simple token validation for testing
    public boolean validateToken(String token) {
        return token != null && token.startsWith("simple-token-");
    }
    
    public String extractUsername(String token) {
        return "user"; // Simple return for testing
    }
}
