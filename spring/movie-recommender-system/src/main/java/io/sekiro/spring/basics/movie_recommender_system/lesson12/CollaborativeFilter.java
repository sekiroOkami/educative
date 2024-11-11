package io.sekiro.spring.basics.movie_recommender_system.lesson12;

import io.sekiro.spring.basics.movie_recommender_system.interfaces.Filter;

import javax.inject.Named;

@Named
public class CollaborativeFilter implements Filter {
    @Override
    public String[] getRecommendations(String movie) {
        return new String[]{"HXH", "Jujutsu", "One-piece"};
    }
}
