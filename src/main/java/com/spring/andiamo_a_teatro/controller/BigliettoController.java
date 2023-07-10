package com.spring.andiamo_a_teatro.controller;

import com.spring.andiamo_a_teatro.model.Biglietto;
import com.spring.andiamo_a_teatro.model.Utente;
import com.spring.andiamo_a_teatro.service.BigliettoService;
import com.spring.andiamo_a_teatro.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user/{id}/ticket")
public class BigliettoController {

    @Autowired
    private BigliettoService bigliettoService;

    @Autowired
    private UtenteService utenteService;

    @PostMapping("/create")
    public boolean createTicket(@PathVariable Long id, @RequestBody Biglietto ticket) {
        Optional<Utente> optionalUtente = utenteService.findById(id);

        if (optionalUtente.isEmpty()) return false;

        ticket.setUser(optionalUtente.get());
        bigliettoService.save(ticket);

        return true;
    }

}
