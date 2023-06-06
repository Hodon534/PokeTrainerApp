package com.webapp.poketrainer.controller.cont;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.webapp.poketrainer.model.dto.ContactFormDto;
import com.webapp.poketrainer.service.ContactFormService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ContactController.class) // Map to specific Controller
@AutoConfigureMockMvc(addFilters=false) // Disable Spring Security while testing
class ContactControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ContactController contactController;
    private static final MediaType APPLICATION_JSON = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), StandardCharsets.UTF_8);


    @Test
    void getPage() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/contact"))
                .andExpect(status().isOk());
    }

    @Test
    @Disabled
    void postContactForm() throws Exception {
        ContactFormDto contactFormDto = new ContactFormDto();
        String emailAddress = "email@gmail.com";
        String emailSubject = "Subject";
        String emailBody = "Body";
        contactFormDto.setEmail(emailAddress);
        contactFormDto.setSubject(emailSubject);
        contactFormDto.setMessage(emailBody);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter writer = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = writer.writeValueAsString(contactFormDto);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/contact").contentType(APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isOk())
                .andExpect(model().attribute("contactForm", hasProperty("email", is(emailAddress))));
        /*this.mockMvc
                .perform(MockMvcRequestBuilders.post("/contact"))
                .andExpect(model().attribute("contactForm", hasProperty("email", is(emailAddress))))
                .andExpect(model().attribute("contactForm", hasProperty("subject", is(emailSubject))))
                .andExpect(model().attribute("contactForm", hasProperty("message", is(emailBody))));*/
    }
}