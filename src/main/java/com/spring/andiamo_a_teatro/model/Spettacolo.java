package com.spring.andiamo_a_teatro.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Spettacolo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private LocalDate date;
    @Column(nullable = false)
    private String genre;
    @Column(nullable = false)
    private int durationInMinutes;
    @Column(nullable = false)
    private double price;
    @ManyToOne
    private Sala hall;
}
