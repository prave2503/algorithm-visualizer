package com.algorithm.visualizer.controller;

import com.algorithm.visualizer.model.Algorithm;
import com.algorithm.visualizer.service.AlgorithmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/algorithms")
@CrossOrigin(origins = "*")
public class AlgorithmController {
    
    @Autowired
    private AlgorithmService algorithmService;
    
    @GetMapping
    public List<Algorithm> getAllAlgorithms() {
        return algorithmService.getAllAlgorithms();
    }
    
    @GetMapping("/{id}")
    public Algorithm getAlgorithm(@PathVariable Long id) {
        return algorithmService.getAlgorithmById(id);
    }
}
