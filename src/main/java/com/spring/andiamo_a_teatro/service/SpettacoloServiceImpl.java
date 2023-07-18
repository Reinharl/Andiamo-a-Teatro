package com.spring.andiamo_a_teatro.service;

import com.spring.andiamo_a_teatro.entity.Spettacolo;
import com.spring.andiamo_a_teatro.repository.SpettacoloRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SpettacoloServiceImpl implements SpettacoloService {

    private static final Logger logger = LoggerFactory.getLogger(SpettacoloServiceImpl.class);

    @Autowired
    private SpettacoloRepository spettacoloRepository;

    @Override
    public boolean save(Spettacolo liveShow) {
        List<Spettacolo> optionalSpettacolo = spettacoloRepository.findAllByHall_Id(liveShow.getHall().getId());
        for (Spettacolo spettacolo : optionalSpettacolo) {
            LocalDateTime oraInizioEsistente = spettacolo.getDate();
            LocalDateTime oraFineEsistente = oraInizioEsistente.plusMinutes(spettacolo.getDurationInMinutes());

            if (liveShow.getDate().isBefore(oraFineEsistente) && liveShow.getDate().isAfter(oraInizioEsistente)) {
                return false;
            }
        }

        logger.info(("Save live show: " + liveShow));

        spettacoloRepository.save(liveShow);
        return true;
    }


}
