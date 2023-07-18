package com.spring.andiamo_a_teatro.service;

import com.spring.andiamo_a_teatro.entity.Posto;
import com.spring.andiamo_a_teatro.repository.PostoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostoServiceImpl implements PostoService {

    private static final Logger logger = LoggerFactory.getLogger(PostoServiceImpl.class);

    @Autowired
    private PostoRepository postoRepository;

    @Override
    public boolean save(Posto seat) {
        logger.info("Save seat: " + seat);

        postoRepository.save(seat);
        return true;
    }
}
