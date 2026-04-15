package com.algorithmvisualizer.controller;

import com.algorithmvisualizer.model.Algorithm;
import com.algorithmvisualizer.repository.AlgorithmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/algorithms")
@CrossOrigin(origins = "*")
public class AlgorithmController {
    
    @Autowired
    private AlgorithmRepository algorithmRepository;
    
    @GetMapping
    public List<Algorithm> getAllAlgorithms() {
        return algorithmRepository.findAll();
    }
    
    @GetMapping("/category/{category}")
    public List<Algorithm> getByCategory(@PathVariable String category) {
        return algorithmRepository.findByCategory(category);
    }
    
    @GetMapping("/difficulty/{difficulty}")
    public List<Algorithm> getByDifficulty(@PathVariable String difficulty) {
        return algorithmRepository.findByDifficulty(difficulty);
    }
    
    @PostMapping
    public Algorithm createAlgorithm(@RequestBody Algorithm algorithm) {
        return algorithmRepository.save(algorithm);
    }
}
