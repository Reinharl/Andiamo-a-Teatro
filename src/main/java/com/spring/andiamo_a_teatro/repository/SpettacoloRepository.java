package com.spring.andiamo_a_teatro.repository;

import com.spring.andiamo_a_teatro.model.Spettacolo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpettacoloRepository extends JpaRepository<Spettacolo, Long> {
}
