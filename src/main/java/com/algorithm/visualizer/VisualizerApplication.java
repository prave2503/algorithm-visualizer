package com.algorithm.visualizer;

import com.algorithm.visualizer.service.AlgorithmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VisualizerApplication implements CommandLineRunner {
    
    @Autowired
    private AlgorithmService algorithmService;
    
    public static void main(String[] args) {
        SpringApplication.run(VisualizerApplication.class, args);
    }
    
    @Override
    public void run(String... args) throws Exception {
        algorithmService.seedAlgorithms();
        System.out.println("\n🚀 Algorithm Visualizer is running!");
        System.out.println("📊 Open: http://localhost:8080");
        System.out.println("🗄️ H2 Console: http://localhost:8080/h2-console");
        System.out.println("\n✨ Features:");
        System.out.println("   • Visualize sorting algorithms");
        System.out.println("   • Create collaborative rooms");
        System.out.println("   • Share code in real-time");
        System.out.println("   • Learn algorithm complexity\n");
    }
}
