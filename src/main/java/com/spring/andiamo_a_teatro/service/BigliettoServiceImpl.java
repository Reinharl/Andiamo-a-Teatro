package com.spring.andiamo_a_teatro.service;

import com.spring.andiamo_a_teatro.entity.Biglietto;
import com.spring.andiamo_a_teatro.repository.BigliettoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BigliettoServiceImpl implements BigliettoService {

    private static final Logger logger = LoggerFactory.getLogger(BigliettoServiceImpl.class);

    @Autowired
    private BigliettoRepository bigliettoRepository;

    @Override
    public boolean save(Biglietto ticket) {
        logger.info("Save ticket: " + ticket);

        bigliettoRepository.save(ticket);
        return true;
    }
}
