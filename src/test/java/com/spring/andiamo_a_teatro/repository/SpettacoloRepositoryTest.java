package com.spring.andiamo_a_teatro.repository;

import com.spring.andiamo_a_teatro.entity.Sala;
import com.spring.andiamo_a_teatro.entity.Sede;
import com.spring.andiamo_a_teatro.entity.Spettacolo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class SpettacoloRepositoryTest {

    @Autowired
    private SpettacoloRepository spettacoloRepository;

    @Autowired
    private TestEntityManager entityManager;


    @BeforeEach
    void setUp() {

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

        Spettacolo spettacolo = Spettacolo.builder()
                .date(LocalDateTime.now().plusMonths(1))
                .genre("Commedia")
                .durationInMinutes(90)
                .price(10)
                .hall(sala)
                .build();

        entityManager.persist(spettacolo);
    }

    @Test
    public void findAllByHallId_thenReturnLiveShows() {
        List<Spettacolo> spettacoli = spettacoloRepository.findAllByHall_Id(2L);

        assertEquals(spettacoli.get(0).getPrice(), 10);
    }

    @Test
    public void findAllByHall_Venue_CityAndDateBetween_thenReturnLiveShows() {
        LocalDateTime startTime = LocalDate.now().plusMonths(1).atStartOfDay();
        LocalDateTime endTime = LocalDate.now().plusMonths(1).atTime(23, 59, 59);

        List<Spettacolo> spettacoli = spettacoloRepository.findAllByHall_Venue_CityAndDateBetween("Bari", startTime, endTime);

        assertEquals(spettacoli.get(0).getPrice(), 10);
    }

    @Test
    public void findByCityAndDate_thenReturnLiveShows() {
        List<Spettacolo> spettacoli = spettacoloRepository.findByCityAndDate("Bari", LocalDate.now().plusMonths(1));

        assertEquals(spettacoli.get(0).getPrice(), 10);
    }
}