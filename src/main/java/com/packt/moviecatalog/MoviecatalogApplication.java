package com.packt.moviecatalog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.packt.moviecatalog.domain.Director;
import com.packt.moviecatalog.domain.DirectorRepository;
import com.packt.moviecatalog.domain.Movie;
import com.packt.moviecatalog.domain.MovieRepository;
import com.packt.moviecatalog.domain.Review;
import com.packt.moviecatalog.domain.ReviewRepository;

@SpringBootApplication
public class MoviecatalogApplication {

	private static final Logger logger = LoggerFactory.getLogger(MoviecatalogApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(MoviecatalogApplication.class, args);


	}

	@Bean
	public CommandLineRunner runner(MovieRepository movieRepository, 
	DirectorRepository directorRepository, ReviewRepository reviewRepository) {

		return (args) -> {

			Director exampleDirector = new Director("Ridley Scott");
			Director exampleDirector2 = new Director("John Carpenter");

			directorRepository.save(exampleDirector);
			directorRepository.save(exampleDirector2);

			for (Director director : directorRepository.findAll()) {

				logger.info("Director's name is " + director.getName() + ".");
	
			}

			logger.info("Running the application");

			Movie exampleMovie = new Movie("Blade Runner", 1982, "Sci-Fi", 117, exampleDirector);
			Movie exampleMovie2 = new Movie("The Thing", 1982, "Horror", 109, exampleDirector2);

			movieRepository.save(exampleMovie);
			movieRepository.save(exampleMovie2);

			for (Movie movie : movieRepository.findAll()) {

				logger.info("The movie is " + movie.getTitle() + " and it's genre is " + movie.getGenre() + ".");
	
			}

			Review exampleReview = new Review(4.5, "Good movie!", exampleMovie);
			Review exampleReview2 = new Review(3.5, "Great ending!", exampleMovie2);

			reviewRepository.save(exampleReview);
			reviewRepository.save(exampleReview2);

			for (Review review : reviewRepository.findAll()) {

				logger.info("The score of the review is " + review.getScore() + " and the comment is \"" + review.getComment() + "\".");
	
			}

			for (Movie movie : movieRepository.findAll()) {

				logger.info("The movie is " + movie.getTitle() + " and it's genre is " + movie.getGenre() + ".");
				logger.info("The review score of the movie was " + movie.getReviews().get(0).getScore());
	
			}

		};

	}

}