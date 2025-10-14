package com.fitnesscentre.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "indoor_games")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IndoorGame {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    @Column(columnDefinition = "TEXT")
    private String description;
    
    @Column(name = "price_per_hour", precision = 10, scale = 2)
    private BigDecimal pricePerHour;
    
    @Column(name = "max_players")
    private Integer maxPlayers;
    
    @Column(name = "equipment_provided")
    private String equipmentProvided;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fitness_centre_id", nullable = false)
    private FitnessCentre fitnessCentre;
}
