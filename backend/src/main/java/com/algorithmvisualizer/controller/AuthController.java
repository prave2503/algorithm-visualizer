package com.algorithmvisualizer.controller;

import com.algorithmvisualizer.dto.AuthRequest;
import com.algorithmvisualizer.dto.AuthResponse;
import com.algorithmvisualizer.model.User;
import com.algorithmvisualizer.repository.UserRepository;
import com.algorithmvisualizer.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {
    
    @Autowired
    private JwtService jwtService;
    
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody AuthRequest request) {
        try {
            // Check if user exists
            if (userRepository.findByEmail(request.getEmail()).isPresent()) {
                return ResponseEntity.badRequest().body("Email already exists");
            }
            
            // Create new user (simple - no password encoding for now)
            User user = new User();
            user.setEmail(request.getEmail());
            user.setPassword(request.getPassword()); // Store plain password for now
            user.setUsername(request.getEmail().split("@")[0]);
            user.setCreatedAt(LocalDateTime.now());
            
            userRepository.save(user);
            
            // Generate simple token (just for testing)
            String token = "simple-token-" + user.getId();
            
            return ResponseEntity.ok(new AuthResponse(token, user.getEmail(), user.getUsername()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Registration failed: " + e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
        try {
            // Simple login - check email and password directly
            Optional<User> userOpt = userRepository.findByEmail(request.getEmail());
            
            if (userOpt.isPresent() && userOpt.get().getPassword().equals(request.getPassword())) {
                User user = userOpt.get();
                String token = "simple-token-" + user.getId();
                return ResponseEntity.ok(new AuthResponse(token, user.getEmail(), user.getUsername()));
            } else {
                return ResponseEntity.badRequest().body("Invalid credentials");
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Login failed: " + e.getMessage());
        }
    }
}
