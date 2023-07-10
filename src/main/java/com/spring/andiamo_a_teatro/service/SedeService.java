package com.spring.andiamo_a_teatro.service;

import com.spring.andiamo_a_teatro.model.Sede;
import com.spring.andiamo_a_teatro.repository.SedeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SedeService {

    private static final Logger logger = LoggerFactory.getLogger(SedeService.class);

    @Autowired
    private SedeRepository sedeRepository;

    public void save(Sede venue) {
        logger.info("Save venue: " + venue);

        sedeRepository.save(venue);
    }

    public Optional<Sede> findById(Long id) {
        logger.info("Get venue by Id: " + id);

        return sedeRepository.findById(id);
    }
}
