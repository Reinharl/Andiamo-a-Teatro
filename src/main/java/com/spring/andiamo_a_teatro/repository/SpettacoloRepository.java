package com.spring.andiamo_a_teatro.repository;

import com.spring.andiamo_a_teatro.model.Spettacolo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpettacoloRepository extends JpaRepository<Spettacolo, Long> {
}
