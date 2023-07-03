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
public class Biglietto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private LocalDate dateOfPurchase;
    @ManyToOne
    private Utente user;
    @ManyToOne
    private Posto seat;
    @ManyToOne
    private Spettacolo show;

    public Biglietto(LocalDate dateOfPurchase, Utente user, Posto seat, Spettacolo show) {
        this.dateOfPurchase = dateOfPurchase;
        this.user = user;
        this.seat = seat;
        this.show = show;
    }

}
