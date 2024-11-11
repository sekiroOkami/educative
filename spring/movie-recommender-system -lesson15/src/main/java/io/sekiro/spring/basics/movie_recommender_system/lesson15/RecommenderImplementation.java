package io.sekiro.spring.basics.movie_recommender_system.lesson15;

import io.sekiro.spring.basics.movie_recommender_system.interfaces.Filter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service

public class RecommenderImplementation {

    private Filter filter;
    @Value("${recommender.implementation.favoriteMovie:default value}")
    private String favoriteMovie;

    public String getFavoriteMovie() {
        return favoriteMovie;
    }

    public void setFavoriteMovie(String favoriteMovie) {
        this.favoriteMovie = favoriteMovie;
    }

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public RecommenderImplementation(Filter filter) {
        logger.info("In RecommenderImplementation Constructor");
        this.filter = filter;
    }

    public String[] recommendMovie(String movie) {
        System.out.println("\nName of the filter in use: " + filter + "\n");
        return filter.getRecommendations(movie);
    }


}
