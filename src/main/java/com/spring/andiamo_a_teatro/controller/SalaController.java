package com.spring.andiamo_a_teatro.controller;

import com.spring.andiamo_a_teatro.entity.Sala;
import com.spring.andiamo_a_teatro.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hall")
public class SalaController {

    @Autowired
    private SalaService salaService;

    @PostMapping("/create")
    public boolean createHall(@RequestBody Sala hall) {
        return salaService.save(hall);
    }
}
