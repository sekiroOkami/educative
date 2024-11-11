package io.sekiro.spring.basics.movie_recommender_system.lesson13;

import io.sekiro.spring.basics.movie_recommender_system.interfaces.Filter;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class ContentBasedFilter implements Filter {
    private static int instance = 0;
    private Movie movie;


    public ContentBasedFilter(Movie movie) {
        instance++;
//        System.out.println("ContentBasedFilter constructor called");
        this.movie = movie;
    }

    public static int getInstance() {
        return ContentBasedFilter.instance;
    }

    @Override
    public String[] getRecommendations(String movie) {
        return new String[]{"HXH", "Jujutsu", "One-piece"};
    }
}
