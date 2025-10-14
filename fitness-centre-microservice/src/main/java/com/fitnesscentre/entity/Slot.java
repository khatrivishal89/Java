package com.fitnesscentre.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "slots")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Slot {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "start_time", nullable = false)
    private LocalDateTime startTime;
    
    @Column(name = "end_time", nullable = false)
    private LocalDateTime endTime;
    
    @Column(name = "max_capacity", nullable = false)
    private Integer maxCapacity;
    
    @Column(name = "current_bookings", nullable = false)
    private Integer currentBookings = 0;
    
    @Column(name = "is_available", nullable = false)
    private Boolean isAvailable = true;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fitness_centre_id", nullable = false)
    private FitnessCentre fitnessCentre;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "indoor_game_id")
    private IndoorGame indoorGame;
    
    @ManyToMany(mappedBy = "bookedSlots")
    private List<User> bookedUsers;
    
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
    
    public boolean hasCapacity() {
        return currentBookings < maxCapacity;
    }
    
    public void incrementBooking() {
        this.currentBookings++;
        if (this.currentBookings >= this.maxCapacity) {
            this.isAvailable = false;
        }
    }
    
    public void decrementBooking() {
        if (this.currentBookings > 0) {
            this.currentBookings--;
            this.isAvailable = true;
        }
    }
}
