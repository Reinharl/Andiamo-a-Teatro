package com.spring.andiamo_a_teatro.controller;

import com.spring.andiamo_a_teatro.model.Sede;
import com.spring.andiamo_a_teatro.service.SedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/venue")
public class SedeController {

    @Autowired
    private SedeService sedeService;

    @PostMapping("/create")
    public void createVenue(@RequestBody Sede venue) {
        sedeService.save(venue);
    }

    @GetMapping("/get/{id}")
    public Optional<Sede> getVenue(@PathVariable Long id) {
        return sedeService.findById(id);
    }
}
