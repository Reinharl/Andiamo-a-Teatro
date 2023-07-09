package com.spring.andiamo_a_teatro.service;

import com.spring.andiamo_a_teatro.model.Utente;
import com.spring.andiamo_a_teatro.repository.UtenteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtenteService {

    private static final Logger logger = LoggerFactory.getLogger(UtenteService.class);

    @Autowired
    private UtenteRepository utenteRepository;

    public List<Utente> findAll() {
        logger.info("Get all users");

        return utenteRepository.findAll();
    }

    public Optional<Utente> findByID(Long id) {
        logger.info("Get user by id: " + id);

        if (id == 0)
            return Optional.empty();

        return utenteRepository.findById(id);
    }

    public void save(Utente user) {
        logger.info("Save user: " + user);

        utenteRepository.save(user);
    }

    public void update(Utente user) {
        Optional<Utente> optionalUtente = utenteRepository.findById(user.getId());
        if (optionalUtente.isEmpty()) return;

        System.out.println("test");
        logger.info("Update user: " + user);

        utenteRepository.save(user);
    }

    public void deleteAll() {
        logger.info("Delete all users");

        utenteRepository.deleteAll();
    }

    public void deleteByID(Long id) {
        logger.info("Delete user: " + id);

        utenteRepository.deleteById(id);
    }


}
