package com.webapp.poketrainer.util.api;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class ApiService {

    @Autowired
    private WebClient webClient;

    public String requestData(String url) {
        System.out.println(url);
        return webClient
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
