package com.spring.andiamo_a_teatro.service;

import com.spring.andiamo_a_teatro.entity.Sala;
import com.spring.andiamo_a_teatro.repository.SalaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaServiceImpl implements SalaService {

    private static final Logger logger = LoggerFactory.getLogger(SalaServiceImpl.class);

    @Autowired
    private SalaRepository salaRepository;

    @Override
    public boolean save(Sala hall) {
        logger.info("Save hall: " + hall);

        salaRepository.save(hall);
        return true;
    }
}
