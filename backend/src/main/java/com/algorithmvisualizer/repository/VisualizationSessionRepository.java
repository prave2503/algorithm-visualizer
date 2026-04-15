package com.algorithmvisualizer.repository;

import com.algorithmvisualizer.model.VisualizationSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface VisualizationSessionRepository extends JpaRepository<VisualizationSession, Long> {
    List<VisualizationSession> findByUserId(Long userId);
    List<VisualizationSession> findByAlgorithmId(Long algorithmId);
    List<VisualizationSession> findByStatus(String status);
    List<VisualizationSession> findByIsPublicTrue();
}
