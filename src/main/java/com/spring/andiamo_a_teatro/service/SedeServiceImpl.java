package com.spring.andiamo_a_teatro.service;

import com.spring.andiamo_a_teatro.entity.Sede;
import com.spring.andiamo_a_teatro.repository.SedeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SedeServiceImpl implements SedeService {

    private static final Logger logger = LoggerFactory.getLogger(SedeServiceImpl.class);

    @Autowired
    private SedeRepository sedeRepository;

    @Override
    public boolean save(Sede venue) {
        logger.info("Save venue: " + venue);

        sedeRepository.save(venue);
        return true;
    }

}
