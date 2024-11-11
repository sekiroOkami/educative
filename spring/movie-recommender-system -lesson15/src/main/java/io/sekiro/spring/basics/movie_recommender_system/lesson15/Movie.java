package io.sekiro.spring.basics.movie_recommender_system.lesson15;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Movie {
    // for keeping track of instances created
    private static int instance = 0;
    private int id;
    private String name;
    private String genre;
    private String producer;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public Movie() {
        instance++;
        System.out.println("Movie constructor called.");
    }

    public static int getInstance() {
        return Movie.instance;
    }

    @PostConstruct
    public void postConstruct() {
        logger.info("In Movie postConstruct()");
    }

    @PreDestroy
    public void preDestroy() {
        logger.info("In Movie preDestroy()");
    }
}
