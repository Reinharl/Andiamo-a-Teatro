package com.spring.andiamo_a_teatro.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Posto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private int lineNumber;
    @Column(nullable = false)
    private int seatNumber;
    @ManyToOne
    private Sala hall;

}
