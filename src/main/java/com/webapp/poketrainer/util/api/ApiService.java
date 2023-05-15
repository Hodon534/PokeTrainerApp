package com.webapp.poketrainer.util.api;

import com.webapp.poketrainer.util.api.ApiLinkCreator;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

public class ApiService {
    private static final ApiLinkCreator apiLinkCreator = new ApiLinkCreator();


    public static String requestData(int value) {
        String url = apiLinkCreator.createLink(value);

        WebClient.Builder builder = WebClient.builder();
        System.out.println(url);
        return builder
                .build()
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
