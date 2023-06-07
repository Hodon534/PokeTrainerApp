package com.webapp.poketrainer.util.api;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * Class responsible for making API requests to external sites
 */
@Component
@AllArgsConstructor
public class ApiService {

    @Autowired
    private WebClient webClient;

    /**
     * Make a request to website with url provided as argument and parse the output as String
     * @param url - Link that will allow to send an API request
     * @return - API response as String
     */
    public String requestData(String url) {
        //System.out.println(url);
        return webClient
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
