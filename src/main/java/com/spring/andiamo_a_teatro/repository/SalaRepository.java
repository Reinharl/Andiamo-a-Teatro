package com.spring.andiamo_a_teatro.repository;

import com.spring.andiamo_a_teatro.entity.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaRepository extends JpaRepository<Sala, Long> {
}
