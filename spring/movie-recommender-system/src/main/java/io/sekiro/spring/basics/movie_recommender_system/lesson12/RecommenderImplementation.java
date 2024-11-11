package io.sekiro.spring.basics.movie_recommender_system.lesson12;

import io.sekiro.spring.basics.movie_recommender_system.interfaces.Filter;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class RecommenderImplementation {

    private Filter filter;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Inject
    public RecommenderImplementation(@Qualifier("CF") Filter filter) {
        logger.info("In RecommenderImplementation Constructor");
        this.filter = filter;
    }

    public String[] recommendMovie(String movie) {
        System.out.println("\nName of the filter in use: " + filter + "\n");
        return filter.getRecommendations(movie);
    }
}
