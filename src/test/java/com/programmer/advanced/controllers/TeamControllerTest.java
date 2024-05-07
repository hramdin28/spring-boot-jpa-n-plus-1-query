package com.programmer.advanced.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
class TeamControllerTest {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Ce test appelle une API qui produit l'exception IOException("My IO Exception"). Dans Spring,
     * que pouvez-vous faire pour gérer toutes les erreurs de manière centralisée ?  Ecrivez le code
     * requis pour y parvenir.
     *
     * @throws Exception
     */
    @Test
    void should_get_http_custom_error_when_error_api_is_called() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/team"))
              .andExpect(MockMvcResultMatchers.status().is5xxServerError())
              .andExpect(result -> Assertions.assertEquals("My IO Exception",
                    result.getResolvedException().getMessage()));


    }
}
