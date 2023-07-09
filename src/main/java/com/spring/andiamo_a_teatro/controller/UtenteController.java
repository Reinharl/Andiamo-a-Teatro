package com.spring.andiamo_a_teatro.controller;

import com.spring.andiamo_a_teatro.model.Utente;
import com.spring.andiamo_a_teatro.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UtenteController {

    @Autowired
    private UtenteService utenteService;

    @PostMapping("/register")
    public void saveUser(@RequestBody Utente user) {
        //TODO Implementare la logica di sicurezza
        utenteService.save(user);
    }

    @PutMapping("/update")
    public void updateUser(@RequestBody Utente user) {
        utenteService.update(user);
    }

    @GetMapping("/get/{id}")
    public Optional<Utente> getUser(@PathVariable Long id) {
        return utenteService.findByID(id);
    }

    @GetMapping("/get-all")
    public List<Utente> getAllUser() {

        return utenteService.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUserById(@PathVariable Long id) {

        utenteService.deleteByID(id);
    }

    @DeleteMapping("/delete-all")
    public void deleteAll() {
        utenteService.deleteAll();
    }

}
