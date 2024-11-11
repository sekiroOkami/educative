package io.sekiro.spring.basics.movie_recommender_system.lesson11;

import io.sekiro.spring.basics.movie_recommender_system.interfaces.Filter;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component
public class RecommenderImplementation {

    private Filter filter;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public RecommenderImplementation(@Qualifier(value = "contentBasedFilterLesson11") Filter filter) {
        logger.info("In RecommenderImplementation Constructor .. di");
        this.filter = filter;
    }

    @PostConstruct
    public void postConstruct() {
        logger.info("In RecommenderImplementation postConstruct()");
    }

    @PreDestroy
    public void preDestroy() {
        logger.info("In RecommenderImplementation preDestroy() ");
    }

    public String[] recommendMovie(String movie) {
        System.out.println("\nName of the filter in use: " + filter + "\n");
        return filter.getRecommendations(movie);
    }
}
