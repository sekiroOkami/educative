package io.sekiro.spring.basics.movie_recommender_system.lesson1;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

//@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Movie {
    // for keeping track of instances created
    private static int instance = 0;
    private int id;
    private String name;
    private String genre;
    private String producer;

    public Movie() {
        instance++;
        System.out.println("Movie constructor called.");
    }

    public static int getInstance() {
        return Movie.instance;
    }
}
