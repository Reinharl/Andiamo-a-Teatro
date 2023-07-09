package com.spring.andiamo_a_teatro.controller;

import com.spring.andiamo_a_teatro.model.Sala;
import com.spring.andiamo_a_teatro.model.Sede;
import com.spring.andiamo_a_teatro.service.SalaService;
import com.spring.andiamo_a_teatro.service.SedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/venue/{id}/hall")
public class SalaController {

    @Autowired
    private SalaService salaService;

    @Autowired
    private SedeService sedeService;

    @PostMapping("/create")
    public boolean createHall(@PathVariable Long id, @RequestBody Sala hall) {
        Optional<Sede> optionalSede = sedeService.findById(id);

        if (optionalSede.isEmpty()) return false;

        hall.setVenue(optionalSede.get());
        salaService.save(hall);

        return true;
    }
}
