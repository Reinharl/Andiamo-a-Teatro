package com.spring.andiamo_a_teatro.controller;

import com.spring.andiamo_a_teatro.entity.Utente;
import com.spring.andiamo_a_teatro.service.UtenteService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(UtenteController.class)
class UtenteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UtenteService utenteService;


    @Test
    void saveUser() throws Exception {
        Utente inputUtente = Utente.builder()
                .firstName("Mario")
                .lastName("Rossi")
                .address("Via Rossi 1")
                .email("m.rossi@email.it")
                .phoneNumber("39 333 444 5555")
                .build();

        Mockito.when(utenteService.save(inputUtente)).thenReturn(true);

        mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/user/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                  "firstName": "Mario",
                                  "lastName": "Rossi",
                                  "address": "Via Rossi 1",
                                  "email": "m.rossi@email.it",
                                  "phoneNumber": "39 333 444 5555"
                                }"""))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}