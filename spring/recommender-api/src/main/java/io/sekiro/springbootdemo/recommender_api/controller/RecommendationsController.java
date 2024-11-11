package io.sekiro.springbootdemo.recommender_api.controller;

import io.sekiro.springbootdemo.recommender_api.models.Movie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class RecommendationsController {

    @GetMapping("/movies")
    public List<Movie> getAllMovies() {
        return Arrays.asList(
                new Movie(1, "HXH", 11.0),
                new Movie(2, "Jujutsu", 8.5),
                new Movie(3, "One-piece", 6)
        );
    }
}
