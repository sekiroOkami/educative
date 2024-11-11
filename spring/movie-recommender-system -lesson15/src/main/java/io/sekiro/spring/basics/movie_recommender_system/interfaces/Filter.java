package io.sekiro.spring.basics.movie_recommender_system.interfaces;

public interface Filter {
    public String[] getRecommendations(String movie);
}
