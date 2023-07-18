package com.spring.andiamo_a_teatro.service;

import com.spring.andiamo_a_teatro.entity.Spettacolo;
import com.spring.andiamo_a_teatro.entity.Utente;
import com.spring.andiamo_a_teatro.exception.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface UtenteService {

    List<Utente> findAll();

    Optional<Utente> findById(Long id);

    boolean save(Utente user);

    boolean update(Utente user);

    boolean deleteAll();

    boolean deleteByID(Long id);

    Double buyTicket(Long id_utente, Long id_show, Long id_seat) throws UnregisteredUserException, NonExistentShowException, NonExistentSeatException, ShowException, SeatException, TicketException;

    List<Spettacolo> findByCityAndDate(String city, LocalDate date);

    List<Spettacolo> prompts(Long id_utente) throws UnregisteredUserException;
}
