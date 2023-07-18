package com.spring.andiamo_a_teatro.service;

import com.spring.andiamo_a_teatro.entity.Biglietto;
import com.spring.andiamo_a_teatro.entity.Posto;
import com.spring.andiamo_a_teatro.entity.Spettacolo;
import com.spring.andiamo_a_teatro.entity.Utente;
import com.spring.andiamo_a_teatro.exception.*;
import com.spring.andiamo_a_teatro.repository.BigliettoRepository;
import com.spring.andiamo_a_teatro.repository.PostoRepository;
import com.spring.andiamo_a_teatro.repository.SpettacoloRepository;
import com.spring.andiamo_a_teatro.repository.UtenteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UtenteServiceImpl implements UtenteService {

    private static final Logger logger = LoggerFactory.getLogger(UtenteServiceImpl.class);

    @Autowired
    private UtenteRepository utenteRepository;
    @Autowired
    private SpettacoloRepository liveShowRepository;
    @Autowired
    private PostoRepository seatRepository;
    @Autowired
    private BigliettoRepository ticketRepository;

    public List<Utente> findAll() {
        logger.info("Get all users");

        return utenteRepository.findAll();
    }

    @Override
    public Optional<Utente> findById(Long id) {
        logger.info("Get user by id: " + id);

        if (id == 0)
            return Optional.empty();

        return utenteRepository.findById(id);
    }

    @Override
    public boolean save(Utente user) {
        logger.info("Save user: " + user);

        utenteRepository.save(user);
        return true;
    }

    @Override
    public boolean update(Utente user) {
        Optional<Utente> optionalUtente = utenteRepository.findById(user.getId());
        if (optionalUtente.isEmpty()) return false;

        System.out.println("test");
        logger.info("Update user: " + user);

        utenteRepository.save(user);
        return true;
    }

    @Override
    public boolean deleteAll() {
        logger.info("Delete all users");

        utenteRepository.deleteAll();
        return true;
    }

    @Override
    public boolean deleteByID(Long id) {
        logger.info("Delete user: " + id);

        utenteRepository.deleteById(id);
        return true;
    }

    @Override
    public Double buyTicket(Long id_utente, Long id_show, Long id_seat) throws
            UnregisteredUserException,
            NonExistentShowException,
            NonExistentSeatException,
            ShowException,
            SeatException,
            TicketException {

        Optional<Utente> optionalUtente = utenteRepository.findById(id_utente);
        if (optionalUtente.isEmpty()) throw new UnregisteredUserException("Unregistered User");
        Utente utente = optionalUtente.get();


        Optional<Spettacolo> optionalLiveShow = liveShowRepository.findById(id_show);
        if (optionalLiveShow.isEmpty()) throw new NonExistentShowException("Non Existent Show");
        Spettacolo liveShow = optionalLiveShow.get();

        Optional<Posto> optionalSeat = seatRepository.findById(id_seat);
        if (optionalSeat.isEmpty()) throw new NonExistentSeatException("Non Existent Seat");
        Posto seat = optionalSeat.get();

        if (liveShow.getDate().isBefore(LocalDateTime.now()))
            throw new ShowException("Show Already Over");


        if (!ticketRepository.findAllBySeat_IdAndShow_Id(id_seat, id_show).isEmpty())
            throw new SeatException("Seat Already Booked");

        if (ticketRepository.findAllByUser_IdAndShow_Id(id_utente, id_show).size() >= 4)
            throw new TicketException("Maximum Number of Tickets Booked Exceeded");

        Biglietto biglietto = Biglietto.builder()
                .dateOfPurchase(LocalDate.now())
                .user(utente)
                .seat(seat)
                .show(liveShow)
                .build();

        ticketRepository.save(biglietto);

        logger.info("Purchase shipment successful, Price: " + liveShow.getPrice());
        return liveShow.getPrice();
    }

    @Override
    public List<Spettacolo> findByCityAndDate(String city, LocalDate date) {
        logger.info("Find LiveShow from City: " + city + " and Date: " + date);

        return liveShowRepository.findByCityAndDate(city, date);
    }

    @Override
    public List<Spettacolo> prompts(Long id_utente) throws UnregisteredUserException {
        Optional<Utente> optionalUtente = utenteRepository.findById(id_utente);
        if (optionalUtente.isEmpty()) throw new UnregisteredUserException("Unregistered User");

        logger.info("Prompts LiveShow of User: " + id_utente);

        return liveShowRepository.findSuggestedShowsByUser(id_utente);
    }

}
