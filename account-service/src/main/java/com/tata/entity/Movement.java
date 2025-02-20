package com.tata.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@ToString
@Setter
@Getter
@AllArgsConstructor
@Table(name = "movement_table")
@Entity
public class Movement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movement")
    private Integer idMovement;
    @Column(nullable = false)
    private LocalDateTime date;
    @Enumerated(EnumType.STRING)
    private MovementType movementType;
    @Column(nullable = false)
    private double value;
    private double balance;
    @ManyToOne
    @JoinColumn(name = "id_account")
    private Account account;

    public Movement() {
        this.date = LocalDateTime.now();
    }
}
