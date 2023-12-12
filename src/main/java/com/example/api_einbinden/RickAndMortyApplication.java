package com.example.api_einbinden;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class RickAndMortyApplication {

    public static void main(String[] args) {
        SpringApplication.run(RickAndMortyApplication.class, args);
    }

    @Bean
    WebClient defineWebclient(){
        return WebClient.builder().baseUrl("https://rickandmortyapi.com").build();
    }
}
