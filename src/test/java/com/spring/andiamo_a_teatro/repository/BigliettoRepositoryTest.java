package com.spring.andiamo_a_teatro.repository;

import com.spring.andiamo_a_teatro.entity.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class BigliettoRepositoryTest {

    @Autowired
    private BigliettoRepository bigliettoRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Utente utente = Utente.builder()
                .firstName("Mario")
                .lastName("Rossi")
                .address("Via Rossi, 1")
                .email("m.rossi@email.it")
                .phoneNumber("+39 333 444 5555")
                .build();

        entityManager.persist(utente);

        Sede sede = Sede.builder()
                .name("Politeama di Bari")
                .city("Bari")
                .address("Via uno")
                .isIndoors(true)
                .build();

        entityManager.persist(sede);

        Sala sala = Sala.builder()
                .name("Sala 1")
                .venue(sede)
                .build();

        entityManager.persist(sala);

        Posto posto = Posto.builder()
                .lineNumber(1)
                .seatNumber(1)
                .hall(sala)
                .build();

        entityManager.persist(posto);

        Spettacolo spettacolo = Spettacolo.builder()
                .date(LocalDateTime.now().plusMonths(1))
                .genre("Commedia")
                .durationInMinutes(90)
                .price(10)
                .hall(sala)
                .build();

        entityManager.persist(spettacolo);

        Biglietto biglietto = Biglietto.builder()
                .dateOfPurchase(LocalDate.now())
                .user(utente)
                .seat(posto)
                .show(spettacolo)
                .build();

        entityManager.persist(biglietto);
    }

    @Test
    public void findAllBySeat_IdAndShow_Id_thenReturnTickets() {
        List<Biglietto> biglietti = bigliettoRepository.findAllBySeat_IdAndShow_Id(1L, 1L);

        assertEquals(biglietti.get(0).getDateOfPurchase(), LocalDate.now());
    }

    @Test
    public void findAllByUser_IdAndShow_Id_thenReturnTickets() {
        List<Biglietto> biglietti = bigliettoRepository.findAllByUser_IdAndShow_Id(2L, 2L);

        assertEquals(biglietti.get(0).getDateOfPurchase(), LocalDate.now());
    }
}