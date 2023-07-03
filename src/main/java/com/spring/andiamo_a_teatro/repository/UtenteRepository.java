package com.spring.andiamo_a_teatro.repository;

import com.spring.andiamo_a_teatro.model.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtenteRepository extends JpaRepository<Utente, Long> {
}
