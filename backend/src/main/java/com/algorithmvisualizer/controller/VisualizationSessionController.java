package com.algorithmvisualizer.controller;

import com.algorithmvisualizer.model.VisualizationSession;
import com.algorithmvisualizer.repository.VisualizationSessionRepository;
import com.algorithmvisualizer.repository.UserRepository;
import com.algorithmvisualizer.repository.AlgorithmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/sessions")
@CrossOrigin(origins = "*")
public class VisualizationSessionController {
    
    @Autowired
    private VisualizationSessionRepository sessionRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private AlgorithmRepository algorithmRepository;
    
    // Get all sessions
    @GetMapping
    public List<VisualizationSession> getAllSessions() {
        return sessionRepository.findAll();
    }
    
    // Get sessions by user
    @GetMapping("/user/{userId}")
    public List<VisualizationSession> getSessionsByUser(@PathVariable Long userId) {
        return sessionRepository.findByUserId(userId);
    }
    
    // Get sessions by algorithm
    @GetMapping("/algorithm/{algorithmId}")
    public List<VisualizationSession> getSessionsByAlgorithm(@PathVariable Long algorithmId) {
        return sessionRepository.findByAlgorithmId(algorithmId);
    }
    
    // Get public sessions
    @GetMapping("/public")
    public List<VisualizationSession> getPublicSessions() {
        return sessionRepository.findByIsPublicTrue();
    }
    
    // Create new session
    @PostMapping
    public VisualizationSession createSession(@RequestBody VisualizationSession session) {
        session.setCreatedAt(LocalDateTime.now());
        session.setLastAccessed(LocalDateTime.now());
        session.setStepsCompleted(0);
        return sessionRepository.save(session);
    }
    
    // Update session progress
    @PutMapping("/{id}/progress")
    public VisualizationSession updateProgress(@PathVariable Long id, @RequestParam Integer steps) {
        VisualizationSession session = sessionRepository.findById(id).orElse(null);
        if (session != null) {
            session.setStepsCompleted(steps);
            session.setLastAccessed(LocalDateTime.now());
            if (steps >= session.getTotalSteps()) {
                session.setStatus("COMPLETED");
            }
            return sessionRepository.save(session);
        }
        return null;
    }
    
    // Delete session
    @DeleteMapping("/{id}")
    public void deleteSession(@PathVariable Long id) {
        sessionRepository.deleteById(id);
    }
}
