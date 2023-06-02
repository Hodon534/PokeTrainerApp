package com.webapp.poketrainer.controller.cont;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = FreebiesController.class) // Map to specific Controller
@AutoConfigureMockMvc(addFilters=false) // Disable Spring Security while testing
class FreebiesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getPage() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/freebies"))
                .andExpect(status().isOk());
    }
}