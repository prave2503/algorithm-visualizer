package com.algorithm.visualizer.repository;

import com.algorithm.visualizer.model.Algorithm;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AlgorithmRepository extends JpaRepository<Algorithm, Long> {
    List<Algorithm> findByCategory(String category);
}
