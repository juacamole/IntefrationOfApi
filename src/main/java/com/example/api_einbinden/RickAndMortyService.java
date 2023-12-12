package com.example.api_einbinden;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class RickAndMortyService {

    private final WebClient webClient;

    public List <RickAndMortyCharacter> findCharacters(){
        RickAndMortyResponse response = Objects.requireNonNull(
                webClient
                        .get()
                        .uri("/api/character")
                        .retrieve()
                        .toEntity(RickAndMortyResponse.class)
                        .block()
        )
                .getBody();

        List<RickAndMortyCharacter> characters = new ArrayList<>();
        for (RickAndMortyResult result : Objects.requireNonNull(response).results()) {
            characters.add(
                    new RickAndMortyCharacter(result.id(), result.name(), result.species())
            );

        }
        return characters;
    }
    public List <RickAndMortyCharacter> findCharactersById(String id){
        RickAndMortyResponse response = Objects.requireNonNull(
                webClient
                        .get()
                        .uri("/api/character")
                        .retrieve()
                        .toEntity(RickAndMortyResponse.class)
                        .block()
        )
                .getBody();
        List<RickAndMortyCharacter> characters = new ArrayList<>();
        for (RickAndMortyResult result : Objects.requireNonNull(response).results()){
            if (result.id().equals(id)) {
                characters.add(
                        new RickAndMortyCharacter(result.id(), result.name(), result.species())
                );
            }
        }
        return characters;
    }
}
