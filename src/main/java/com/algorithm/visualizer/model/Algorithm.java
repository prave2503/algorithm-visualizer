package com.algorithm.visualizer.model;

import jakarta.persistence.*;

@Entity
public class Algorithm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String category;
    private String complexity;
    
    @Column(length = 1000)
    private String description;
    
    @Column(columnDefinition = "TEXT")
    private String codeTemplate;
    
    @Column(columnDefinition = "TEXT")
    private String visualizationData;
    
    public Algorithm() {}
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public String getComplexity() { return complexity; }
    public void setComplexity(String complexity) { this.complexity = complexity; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getCodeTemplate() { return codeTemplate; }
    public void setCodeTemplate(String codeTemplate) { this.codeTemplate = codeTemplate; }
    public String getVisualizationData() { return visualizationData; }
    public void setVisualizationData(String visualizationData) { this.visualizationData = visualizationData; }
}
