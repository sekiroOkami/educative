package io.sekiro.spring.basics.movie_recommender_system;

import io.sekiro.spring.basics.movie_recommender_system.lesson13.RecommenderImplementation;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@ComponentScan(basePackages = "io.sekiro.spring.basics.movie_recommender_system.lesson14")
public class MovieRecommenderSystemApplication {
	public static void main(String[] args) {
		try(var ctx = new AnnotationConfigApplicationContext(MovieRecommenderSystemApplication.class);) {
			System.out.println("ctx.getClass() = " + ctx.getClass());
			var recommender = ctx.getBean(RecommenderImplementation.class);
			String[] result = recommender.recommendMovie("HXH");
			System.out.println(Arrays.toString(result));
		}
	}
}
