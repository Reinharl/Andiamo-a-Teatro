package com.spring.andiamo_a_teatro.controller;

import com.spring.andiamo_a_teatro.entity.Biglietto;
import com.spring.andiamo_a_teatro.service.BigliettoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticket")
public class BigliettoController {

    @Autowired
    private BigliettoService bigliettoService;

    @PostMapping("/create")
    public boolean createTicket(@RequestBody Biglietto ticket) {

        return bigliettoService.save(ticket);
    }

}
