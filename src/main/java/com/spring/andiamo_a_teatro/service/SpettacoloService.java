package com.spring.andiamo_a_teatro.service;

import com.spring.andiamo_a_teatro.model.Spettacolo;
import com.spring.andiamo_a_teatro.repository.SpettacoloRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpettacoloService {

    Logger logger = LoggerFactory.getLogger(SpettacoloService.class);

    @Autowired
    private SpettacoloRepository spettacoloRepository;

    public void save(Spettacolo liveShow) {
        logger.info(("Save live show: " + liveShow));

        spettacoloRepository.save(liveShow);
    }


}
