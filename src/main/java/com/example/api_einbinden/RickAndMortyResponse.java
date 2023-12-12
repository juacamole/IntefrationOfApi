package com.example.api_einbinden;

import java.util.List;

public record RickAndMortyResponse(
        int total,
        List< RickAndMortyResult > results
){
}
