package com.webapp.poketrainer.util.api;

import lombok.AllArgsConstructor;
import net.joshka.junit.json.params.JsonFileSource;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;
import org.springframework.core.io.ClassPathResource;

import javax.json.JsonObject;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@JsonTest
@AllArgsConstructor
class ApiServiceTest {

    @Autowired
    private JacksonTester<String> jacksonTester;
    @Autowired
    private ApiService apiService;

    //@Test
    @ParameterizedTest
    @JsonFileSource(resources = "/json/cards.json")
    @Disabled
    void requestData(JsonObject jsonObject) throws IOException {
        // given
        String url = "https://api.pokemontcg.io/v2/cards?page=2618&pageSize=1";
        String id = "ex5-19";
        // when
        JsonContent<String> jsonAsString = jacksonTester.write(apiService.requestData(url));
        System.out.println(jsonAsString);
        // then
        assertThat(jsonAsString).extractingJsonPathStringValue("$.id").isEqualTo(id);
        assertThat(jsonAsString).isEqualToJson((CharSequence) jsonObject);
    }
}