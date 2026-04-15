package com.algorithmvisualizer.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "algorithms")
public class Algorithm {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String category;
    private String difficulty;
    
    @Column(length = 1000)
    private String description;
    
    private String timeComplexity;
    private String spaceComplexity;
    
    @Column(length = 2000)
    private String codeSnippet;
    
    private LocalDateTime createdAt;
    
    // Constructors
    public Algorithm() {}
    
    public Algorithm(String name, String category, String difficulty, String description, 
                    String timeComplexity, String spaceComplexity, String codeSnippet) {
        this.name = name;
        this.category = category;
        this.difficulty = difficulty;
        this.description = description;
        this.timeComplexity = timeComplexity;
        this.spaceComplexity = spaceComplexity;
        this.codeSnippet = codeSnippet;
        this.createdAt = LocalDateTime.now();
    }
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    
    public String getDifficulty() { return difficulty; }
    public void setDifficulty(String difficulty) { this.difficulty = difficulty; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public String getTimeComplexity() { return timeComplexity; }
    public void setTimeComplexity(String timeComplexity) { this.timeComplexity = timeComplexity; }
    
    public String getSpaceComplexity() { return spaceComplexity; }
    public void setSpaceComplexity(String spaceComplexity) { this.spaceComplexity = spaceComplexity; }
    
    public String getCodeSnippet() { return codeSnippet; }
    public void setCodeSnippet(String codeSnippet) { this.codeSnippet = codeSnippet; }
    
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
