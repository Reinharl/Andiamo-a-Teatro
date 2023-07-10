package com.spring.andiamo_a_teatro.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Biglietto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private LocalDate dateOfPurchase = LocalDate.now();
    @ManyToOne
    private Utente user;
    @ManyToOne
    private Posto seat;
    @ManyToOne
    private Spettacolo show;

}
