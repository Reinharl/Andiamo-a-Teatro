package com.spring.andiamo_a_teatro.service;

import com.spring.andiamo_a_teatro.model.Biglietto;
import com.spring.andiamo_a_teatro.repository.BigliettoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BigliettoService {

    private static final Logger logger = LoggerFactory.getLogger(BigliettoService.class);

    @Autowired
    private BigliettoRepository bigliettoRepository;

    public void save(Biglietto ticket) {
        logger.info("Save ticket: " + ticket);

        bigliettoRepository.save(ticket);
    }
}
