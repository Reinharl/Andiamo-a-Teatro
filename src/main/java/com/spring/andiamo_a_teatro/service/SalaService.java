package com.spring.andiamo_a_teatro.service;

import com.spring.andiamo_a_teatro.model.Sala;
import com.spring.andiamo_a_teatro.repository.SalaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SalaService {

    private static final Logger logger = LoggerFactory.getLogger(SalaService.class);

    @Autowired
    private SalaRepository salaRepository;

    public void save(Sala hall) {
        logger.info("Save hall: " + hall);

        salaRepository.save(hall);
    }

    public Optional<Sala> findById(Long id) {
        logger.info("Get hall by Id: " + id);

        return salaRepository.findById(id);
    }
}
