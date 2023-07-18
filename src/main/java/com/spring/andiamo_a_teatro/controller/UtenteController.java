package com.spring.andiamo_a_teatro.controller;

import com.spring.andiamo_a_teatro.entity.Spettacolo;
import com.spring.andiamo_a_teatro.entity.Utente;
import com.spring.andiamo_a_teatro.service.UtenteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UtenteController {

    @Autowired
    private UtenteService utenteService;

    @PostMapping("/register")
    public boolean saveUser(@Valid @RequestBody Utente user) {
        //TODO Implementare la logica di sicurezza
        return utenteService.save(user);
    }

    @PutMapping("/update")
    public boolean updateUser(@Valid @RequestBody Utente user) {
        return utenteService.update(user);
    }

    @GetMapping("/get/{id}")
    public Optional<Utente> getUser(@PathVariable Long id) {
        return utenteService.findById(id);
    }

    @GetMapping("/get-all")
    public List<Utente> getAllUser() {

        return utenteService.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteUserById(@PathVariable Long id) {

        return utenteService.deleteByID(id);
    }

    @DeleteMapping("/delete-all")
    public boolean deleteAll() {
        return utenteService.deleteAll();
    }

    @PostMapping("/buy-ticket")
    public Double buyTicket(@RequestParam Long id_user, @RequestParam Long id_show, @RequestParam Long id_seat) {

        return utenteService.buyTicket(id_user, id_show, id_seat);
    }

    @GetMapping("/find")
    public List<Spettacolo> findByCityAndDate(@RequestParam String city, @RequestParam LocalDate date) {

        return utenteService.findByCityAndDate(city, date);
    }

    @GetMapping("/prompts")
    public List<Spettacolo> promptsLiveShow(@RequestParam Long id_user) {

        return utenteService.prompts(id_user);
    }

}
