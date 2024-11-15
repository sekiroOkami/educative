package io.sekiro.spring.basics.movie_recommender_system;
import io.sekiro.spring.basics.movie_recommender_system.lesson12.RecommenderImplementation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class MovieRecommenderSystemApplication {
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(MovieRecommenderSystemApplication.class, args);
		var recommender = ctx.getBean(RecommenderImplementation.class);
		System.out.println(recommender);

	}

}
