package io.sekiro.spring.basics.movie_recommender_system.lesson1;

import io.sekiro.spring.basics.movie_recommender_system.interfaces.Filter;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Component
//@Primary
public class CollaborativeFilter implements Filter {
    @Override
    public String[] getRecommendations(String movie) {
        return new String[]{"HXH", "Jujutsu", "One-piece"};
    }
}
