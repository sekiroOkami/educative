package io.sekiro.spring.basics.movie_recommender_system.lesson1;

import io.sekiro.spring.basics.movie_recommender_system.interfaces.Filter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component
public class RecommenderImplementation {

    private Filter filter;

    public RecommenderImplementation( @Qualifier(value = "contentBasedFilter") Filter filter) {
        this.filter = filter;
    }

    public String[] recommendMovie(String movie) {
        System.out.println("\nName of the filter in use: " + filter + "\n");
        return filter.getRecommendations(movie);
    }
}
