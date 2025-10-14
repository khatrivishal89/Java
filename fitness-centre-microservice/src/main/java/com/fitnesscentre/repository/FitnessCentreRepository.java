package com.fitnesscentre.repository;

import com.fitnesscentre.entity.FitnessCentre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface FitnessCentreRepository extends JpaRepository<FitnessCentre, Long> {
    
    Optional<FitnessCentre> findByName(String name);
    
    boolean existsByName(String name);
}
