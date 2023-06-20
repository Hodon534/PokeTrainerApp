package com.webapp.poketrainer.controller.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = AdminController.class) // Map to specific Controller
@AutoConfigureMockMvc(addFilters=false) // Disable Spring Security while testing
class AdminControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getPage() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/admin"))
                .andExpect(status().isOk());
    }
}