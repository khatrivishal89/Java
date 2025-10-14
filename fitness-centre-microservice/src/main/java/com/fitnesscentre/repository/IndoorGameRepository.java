package com.fitnesscentre.repository;

import com.fitnesscentre.entity.IndoorGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IndoorGameRepository extends JpaRepository<IndoorGame, Long> {
    
    List<IndoorGame> findByFitnessCentreId(Long fitnessCentreId);
    
    boolean existsByNameAndFitnessCentreId(String name, Long fitnessCentreId);
}
