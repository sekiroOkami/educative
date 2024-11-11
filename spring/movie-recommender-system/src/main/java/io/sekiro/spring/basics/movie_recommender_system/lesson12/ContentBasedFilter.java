package io.sekiro.spring.basics.movie_recommender_system.lesson12;

import io.sekiro.spring.basics.movie_recommender_system.interfaces.Filter;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.inject.Named;

@Named(value = "CF")
public class ContentBasedFilter implements Filter {
    private static int instance = 0;
    private Movie movie;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public ContentBasedFilter(Movie movie) {
        logger.info("In ContentBasedFilter constructor");
        instance++;
//        System.out.println("ContentBasedFilter constructor called");
        this.movie = movie;
    }

    @PostConstruct
    public void postConstruct() {
        logger.info("In contentBasedFilter postConstruct()");
    }

    @PreDestroy
    public void preDestroy() {
        logger.info("In contentBasedFilter preDestroy()");
    }

    @Lookup
    public Movie getMovie() {
        return movie;
    }

    public static int getInstance() {
        return ContentBasedFilter.instance;
    }

    @Override
    public String[] getRecommendations(String movie) {
        return new String[]{"HXH", "Jujutsu", "One-piece"};
    }
}
