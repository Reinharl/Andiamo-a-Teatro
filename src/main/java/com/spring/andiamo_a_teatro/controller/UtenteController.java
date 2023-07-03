package com.spring.andiamo_a_teatro.controller;

import com.spring.andiamo_a_teatro.exception.UserDoesNotExistsException;
import com.spring.andiamo_a_teatro.model.Utente;
import com.spring.andiamo_a_teatro.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/utente")
public class UtenteController {

    @Autowired
    UtenteService utenteService;

    @PostMapping("/register")
    public void createUser(@RequestBody Utente user) {
        utenteService.save(user);
    }

    @GetMapping("/get/{id}")
    public Utente getUtente(@PathVariable Long idUtente) throws UserDoesNotExistsException {
        Optional<Utente> optionalUser = utenteService.findByID(idUtente);
        if (optionalUser.isEmpty())
            throw new UserDoesNotExistsException();
        return optionalUser.get();
    }

    @GetMapping("/getall")
    public List<Utente> getAllLocations() {
        return utenteService.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        utenteService.deleteByID(id);
    }

}
