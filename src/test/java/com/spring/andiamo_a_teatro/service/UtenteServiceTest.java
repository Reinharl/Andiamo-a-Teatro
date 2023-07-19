package com.spring.andiamo_a_teatro.service;

import com.spring.andiamo_a_teatro.entity.*;
import com.spring.andiamo_a_teatro.exception.*;
import com.spring.andiamo_a_teatro.repository.BigliettoRepository;
import com.spring.andiamo_a_teatro.repository.PostoRepository;
import com.spring.andiamo_a_teatro.repository.SpettacoloRepository;
import com.spring.andiamo_a_teatro.repository.UtenteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UtenteServiceTest {

    @Autowired
    private UtenteService utenteService;

    @MockBean
    private UtenteRepository utenteRepository;

    @MockBean
    private SpettacoloRepository spettacoloRepository;

    @MockBean
    private PostoRepository postoRepository;

    @MockBean
    private BigliettoRepository bigliettoRepository;

    @BeforeEach
    void setUp() {
        Utente utente = Utente.builder()
                .id(1L)
                .firstName("Mario")
                .lastName("Rossi")
                .address("Via Rossi, 1")
                .email("m.rossi@email.it")
                .phoneNumber("+39 333 444 5555")
                .build();

        Mockito.when(utenteRepository.findById(1L)).thenReturn(Optional.ofNullable(utente));

        Sede sede = Sede.builder()
                .id(1L)
                .name("Politeama di Bari")
                .city("Bari")
                .address("Via uno")
                .isIndoors(true)
                .build();

        Sala sala = Sala.builder()
                .id(1L)
                .name("Sala 1")
                .venue(sede)
                .build();

        Posto posto = Posto.builder()
                .id(1L)
                .lineNumber(1)
                .seatNumber(1)
                .hall(sala)
                .build();

        Mockito.when(postoRepository.findById(1L)).thenReturn(Optional.ofNullable(posto));

        Spettacolo spettacolo = Spettacolo.builder()
                .id(1L)
                .date(LocalDateTime.of(2050, 1, 1, 20, 0, 0))
                .genre("Commedia")
                .durationInMinutes(90)
                .price(10)
                .hall(sala)
                .build();

        Mockito.when(spettacoloRepository.findById(1L)).thenReturn(Optional.ofNullable(spettacolo));
        Mockito.when(spettacoloRepository.findByCityAndDate("Bari", LocalDate.of(2050, 1, 1))).thenReturn(List.of(spettacolo));
        Mockito.when(spettacoloRepository.findSuggestedShowsByUser(1L)).thenReturn(List.of());

        Mockito.when(bigliettoRepository.findAllBySeat_IdAndShow_Id(1L, 1L)).thenReturn(List.of());
        Mockito.when(bigliettoRepository.findAllByUser_IdAndShow_Id(1L, 1L)).thenReturn(List.of());
    }

    @Test
    public void whenValidUserIdShowIdSeatId_thenReturnTicketPrice() throws
            NonExistentShowException,
            UnregisteredUserException,
            TicketException,
            ShowException,
            SeatException,
            NonExistentSeatException {

        Double biglietto = utenteService.buyTicket(1L, 1L, 1L);

        assertEquals(10, biglietto);
    }

    @Test
    public void whenValidCityAndDate_thenReturnLiveShows() {
        List<Spettacolo> spettacoli = utenteService.findByCityAndDate("Bari", LocalDate.of(2050, 1, 1));

        Sede sede = Sede.builder()
                .id(1L)
                .name("Politeama di Bari")
                .city("Bari")
                .address("Via uno")
                .isIndoors(true)
                .build();

        Sala sala = Sala.builder()
                .id(1L)
                .name("Sala 1")
                .venue(sede)
                .build();

        Spettacolo spettacolo = Spettacolo.builder()
                .id(1L)
                .date(LocalDateTime.of(2050, 1, 1, 20, 0, 0))
                .genre("Commedia")
                .durationInMinutes(90)
                .price(10)
                .hall(sala)
                .build();

        assertEquals(List.of(spettacolo), spettacoli);
    }

    @Test
    public void whenValidUserId_thenReturnPrompts() throws UnregisteredUserException {
        List<Spettacolo> spettacoli = utenteService.prompts(1L);

        assertEquals(List.of(), spettacoli);
    }
}