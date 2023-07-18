package com.spring.andiamo_a_teatro.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Spettacolo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private LocalDateTime date;
    @Column(nullable = false)
    private String genre;
    @Column(nullable = false)
    private int durationInMinutes;

    @PositiveOrZero(message = "Add Valid Price")
    @Column(nullable = false)
    private double price;

    @ManyToOne
    private Sala hall;
}
