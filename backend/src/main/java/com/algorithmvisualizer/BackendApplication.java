package com.algorithmvisualizer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
        System.out.println("========================================");
        System.out.println("🚀 Algorithm Visualizer Backend Started!");
        System.out.println("📝 API: http://localhost:8080/api");
        System.out.println("🍃 H2 Console: http://localhost:8080/h2-console");
        System.out.println("========================================");
    }
}
