package com.spring.andiamo_a_teatro.controller;

import com.spring.andiamo_a_teatro.model.Posto;
import com.spring.andiamo_a_teatro.model.Sala;
import com.spring.andiamo_a_teatro.service.PostoService;
import com.spring.andiamo_a_teatro.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/venue/{venue_id}/hall/{hall_id}/")
public class PostoController {

    @Autowired
    private SalaService salaService;

    @Autowired
    private PostoService postoService;

    @PostMapping("/create")
    public boolean createSeat(@PathVariable Long venue_id, @PathVariable Long hall_id, @RequestBody Posto seat) {
        Optional<Sala> optionalSala = salaService.findById(hall_id);

        if (optionalSala.isEmpty() || !optionalSala.get().getVenue().getId().equals(venue_id)) return false;

        seat.setHall(optionalSala.get());
        postoService.save(seat);

        return true;

    }
}
