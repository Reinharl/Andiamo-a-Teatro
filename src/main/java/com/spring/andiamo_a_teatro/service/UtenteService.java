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

    static Logger logger = LoggerFactory.getLogger(UtenteService.class);

    @Autowired
    UtenteRepository utenteRepository;

    public List<Utente> findAll() {
        logger.info("[FINDALL USER]: ");

        return utenteRepository.findAll();
    }

    public Optional<Utente> findByID(Long id) {
        logger.info("[GETBYID USER]: " + id);

        if (id == 0)
            return Optional.empty();

        return utenteRepository.findById(id);
    }

    public Utente save(Utente user) {
        logger.info("[SAVE USER]: " + user);

        return utenteRepository.save(user);
    }

    public Utente update(Utente user) {
        logger.info("[UPDATE USER]: " + user);

        return utenteRepository.save(user);
    }

    public void deleteByID(Long id) {
        logger.info("[DELETE USER]: " + id);

        utenteRepository.deleteById(id);
    }


}
