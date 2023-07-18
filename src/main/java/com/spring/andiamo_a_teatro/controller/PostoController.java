package com.spring.andiamo_a_teatro.controller;

import com.spring.andiamo_a_teatro.entity.Posto;
import com.spring.andiamo_a_teatro.service.PostoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("seat")
public class PostoController {

    @Autowired
    private PostoService postoService;

    @PostMapping("/create")
    public boolean createSeat(@RequestBody Posto seat) {
        return postoService.save(seat);
    }
}
