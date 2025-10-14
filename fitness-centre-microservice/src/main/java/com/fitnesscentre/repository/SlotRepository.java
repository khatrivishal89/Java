package com.fitnesscentre.repository;

import com.fitnesscentre.entity.Slot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SlotRepository extends JpaRepository<Slot, Long> {
    
    List<Slot> findByFitnessCentreId(Long fitnessCentreId);
    
    List<Slot> findByFitnessCentreIdAndIsAvailable(Long fitnessCentreId, Boolean isAvailable);
    
    List<Slot> findByStartTimeBetween(LocalDateTime start, LocalDateTime end);
    
    List<Slot> findByIndoorGameId(Long indoorGameId);
}
