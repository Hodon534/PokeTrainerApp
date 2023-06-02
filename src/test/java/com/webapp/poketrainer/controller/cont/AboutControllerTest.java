package com.webapp.poketrainer.controller.cont;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = AboutController.class) // Map to specific Controller
@AutoConfigureMockMvc(addFilters=false) // Disable Spring Security while testing
class AboutControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void getPage() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/about"))
                .andExpect(status().isOk());
    }
}