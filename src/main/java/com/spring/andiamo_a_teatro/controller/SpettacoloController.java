package com.spring.andiamo_a_teatro.controller;

import com.spring.andiamo_a_teatro.entity.Spettacolo;
import com.spring.andiamo_a_teatro.service.SpettacoloService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/live-show")
public class SpettacoloController {

    @Autowired
    private SpettacoloService spettacoloService;

    @PostMapping("/create")
    public boolean createLiveShow(@Valid @RequestBody Spettacolo liveShow) {

        return spettacoloService.save(liveShow);
    }
}
