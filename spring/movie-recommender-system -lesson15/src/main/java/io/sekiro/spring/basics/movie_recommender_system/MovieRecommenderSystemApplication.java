package io.sekiro.spring.basics.movie_recommender_system;
import io.sekiro.spring.basics.movie_recommender_system.lesson15.RecommenderImplementation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:demo.properties")
public class MovieRecommenderSystemApplication {
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(MovieRecommenderSystemApplication.class, args);
		var recommender = ctx.getBean(RecommenderImplementation.class);
		System.out.println("recommender.getFavoriteMovie() = " + recommender.getFavoriteMovie());
	}
}
