package com.packt.moviecatalog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.packt.moviecatalog.domain.AppUser;
import com.packt.moviecatalog.domain.AppUserRepository;
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
			DirectorRepository directorRepository, ReviewRepository reviewRepository,
			AppUserRepository appUserRepository) {

		return (args) -> {

			logger.info("Running the application");

			Director exampleDirector = new Director("Ridley Scott");
			Director exampleDirector2 = new Director("John Carpenter");
			Director exampleDirector3 = new Director("David Fincher");
			Director exampleDirector4 = new Director("Denis Villeneuve");
			Director exampleDirector5 = new Director("James Cameron");

			directorRepository.save(exampleDirector);
			directorRepository.save(exampleDirector2);
			directorRepository.save(exampleDirector3);
			directorRepository.save(exampleDirector4);
			directorRepository.save(exampleDirector5);

			for (Director director : directorRepository.findAll()) {

				logger.info("Director's name is " + director.getName() + ".");

			}

			Movie exampleMovie = new Movie("Blade Runner", 1982, "Sci-Fi", 117, exampleDirector);
			Movie exampleMovie2 = new Movie("Alien", 1979, "Sci-Fi", 200, exampleDirector);
			Movie exampleMovie3 = new Movie("The Thing", 1982, "Horror", 109, exampleDirector2);
			Movie exampleMovie4 = new Movie("Gone Girl", 2014, "Thriller", 149, exampleDirector3);
			Movie exampleMovie5 = new Movie("Prisoners", 2014, "Crime", 153, exampleDirector4);
			Movie exampleMovie6 = new Movie("The Terminator", 1984, "Action", 107, exampleDirector5);
			Movie exampleMovie7 = new Movie("Aliens", 1986, "Action", 137, exampleDirector5);

			movieRepository.save(exampleMovie);
			movieRepository.save(exampleMovie2);
			movieRepository.save(exampleMovie3);
			movieRepository.save(exampleMovie4);
			movieRepository.save(exampleMovie5);
			movieRepository.save(exampleMovie6);
			movieRepository.save(exampleMovie7);

			for (Movie movie : movieRepository.findAll()) {

				logger.info("The movie is " + movie.getTitle() + " and it's genre is " + movie.getGenre() + ".");

			}

			Review exampleReview = new Review(4.5, "Good movie!", movieRepository.findByTitle("Blade Runner").get(0));
			Review exampleReview2 = new Review(3.5, "Great ending!", movieRepository.findByTitle("The Thing").get(0));

			reviewRepository.save(exampleReview);
			reviewRepository.save(exampleReview2);

			for (Review review : reviewRepository.findAll()) {

				logger.info("The score of the review is " + review.getScore() + " and the comment is \""
						+ review.getComment() + "\".");

			}

			AppUser adminUser = new AppUser("Orava56",
					"$2a$12$qKgRlFPnn78eOc.JDTYWYesQENzbjWpxzFcX/Bf87fFxtAlRDwIPe", "ADMIN");

			appUserRepository.save(adminUser);

		};

	}

}