package com.spring.andiamo_a_teatro.controller;

import com.spring.andiamo_a_teatro.model.Sala;
import com.spring.andiamo_a_teatro.model.Spettacolo;
import com.spring.andiamo_a_teatro.service.SalaService;
import com.spring.andiamo_a_teatro.service.SpettacoloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/venue/{venue_id}/hall/{hall_id}/")
public class SpettacoloController {

    @Autowired
    private SpettacoloService spettacoloService;

    @Autowired
    private SalaService salaService;

    @PostMapping("/live-show/create")
    public boolean createLiveShow(@PathVariable Long venue_id, @PathVariable Long hall_id, @RequestBody Spettacolo liveShow) {
        Optional<Sala> optionalSala = salaService.findById(hall_id);

        if (optionalSala.isEmpty() || !optionalSala.get().getVenue().getId().equals(venue_id)) return false;

        liveShow.setHall(optionalSala.get());
        spettacoloService.save(liveShow);

        return true;
    }
}
