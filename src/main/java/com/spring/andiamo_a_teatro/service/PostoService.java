package com.spring.andiamo_a_teatro.service;

import com.spring.andiamo_a_teatro.model.Posto;
import com.spring.andiamo_a_teatro.repository.PostoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostoService {

    Logger logger = LoggerFactory.getLogger(PostoService.class);

    @Autowired
    private PostoRepository postoRepository;

    public void save(Posto seat) {
        logger.info("Save seat: " + seat);

        postoRepository.save(seat);
    }
}
