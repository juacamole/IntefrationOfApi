package com.example.api_einbinden;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/rickandmorty")
@RequiredArgsConstructor
public class RickAndMortyController{

    private final RickAndMortyService service;

@GetMapping("/characters")
List<RickAndMortyCharacter> findCharacters() {
    return service.findCharacters();
}
@GetMapping("/characters/id/{id}")
List<RickAndMortyCharacter> findCharactersById(@PathVariable String id) {

    return service.findCharactersById(id);
}
@GetMapping("/characters/status/{status}")
List<RickAndMortyCharacter> findCharactersByStatus(@PathVariable String status) {

    return service.findCharactersByStatus(status);
}


}
