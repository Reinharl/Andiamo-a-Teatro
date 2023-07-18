package com.spring.andiamo_a_teatro.controller;

import com.spring.andiamo_a_teatro.entity.Sede;
import com.spring.andiamo_a_teatro.service.SedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/venue")
public class SedeController {

    @Autowired
    private SedeService sedeService;

    @PostMapping("/create")
    public boolean createVenue(@RequestBody Sede venue) {

        return sedeService.save(venue);
    }
}
