package com.fitnesscentre.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "fitness_centres")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FitnessCentre {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private String address;
    
    @Column(name = "phone_number")
    private String phoneNumber;
    
    @Column(name = "email")
    private String email;
    
    @Column(columnDefinition = "TEXT")
    private String description;
    
    @Column(name = "operating_hours")
    private String operatingHours;
    
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    @OneToMany(mappedBy = "fitnessCentre", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<IndoorGame> indoorGames;
    
    @OneToMany(mappedBy = "fitnessCentre", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Slot> slots;
    
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }
    
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
