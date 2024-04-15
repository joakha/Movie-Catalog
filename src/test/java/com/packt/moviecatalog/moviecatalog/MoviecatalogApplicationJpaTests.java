package com.packt.moviecatalog.moviecatalog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import com.packt.moviecatalog.domain.AppUser;
import com.packt.moviecatalog.domain.AppUserRepository;
import com.packt.moviecatalog.domain.Director;
import com.packt.moviecatalog.domain.DirectorRepository;
import com.packt.moviecatalog.domain.Movie;
import com.packt.moviecatalog.domain.MovieRepository;
import com.packt.moviecatalog.domain.Review;
import com.packt.moviecatalog.domain.ReviewRepository;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

@DataJpaTest
public class MoviecatalogApplicationJpaTests {

    @Autowired
	private AppUserRepository appUserRepository;

	@Autowired
	private DirectorRepository directorRepository;

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private ReviewRepository reviewRepository;

    //tests for movies

    @Test void findByTitleReturnMovie() {

        List<Movie> movies = movieRepository.findByTitle("Alien");

        assertThat(movies).hasSize(1);
        assertThat(movies.get(0).getDirector().getName()).isEqualTo("Ridley Scott");

    }

    @Test
    public void createNewMovie() {

        Movie movie = new Movie("Aliens", 1986, "Action", 137, directorRepository.findByName("John Carpenter").get(0));
        movieRepository.save(movie);
        Movie testMovie = movieRepository.findByTitle("Aliens").get(0);

        assertThat(testMovie.getMovieid()).isNotNull();
        assertThat(testMovie.getLength()).isEqualTo(137);

    }

    @Test
    public void deleteMovie() {

        Movie movie = movieRepository.findByTitle("Alien").get(0);
        movieRepository.delete(movie);
        List<Movie> movies = movieRepository.findByTitle("Alien");
        assertThat(movies).hasSize(0);

    }

    //tests for directors

    @Test
    public void findByNameReturnDirector() {

        List<Director> directors = directorRepository.findByName("John Carpenter");
        assertThat(directors).hasSize(1);
        assertThat(directors.get(0).getName()).isEqualTo("John Carpenter");

    }

    @Test
    public void createNewDirector() {

        Director director = new Director("James Cameron");
        directorRepository.save(director);
        Director testDirector = directorRepository.findByName("James Cameron").get(0);
        assertThat(testDirector.getDirectorid()).isNotNull();
        assertThat(testDirector.getName()).isEqualTo("James Cameron");

    }

    @Test
    public void deleteDirector() {

        Director director = directorRepository.findByName("Ridley Scott").get(0);
        directorRepository.delete(director);
        List<Director> directors = directorRepository.findByName("Ridley Scott");
        assertThat(directors).hasSize(0);

    }

    //tests for reviews

    @Test
    public void findByScoreReturnReview() {

        List<Review> reviews = reviewRepository.findByScore(4.5);
        assertThat(reviews).hasSize(1);
        assertThat(reviews.get(0).getComment()).isEqualTo("Good movie!");

    }

    @Test
    public void createNewReview() {

        Review review = new Review(2, "Bad movie :(", movieRepository.findByTitle("Alien").get(0));
        reviewRepository.save(review);
        Review testReview = reviewRepository.findByScore(2).get(0);
        assertThat(testReview.getReviewid()).isNotNull();
        assertThat(testReview.getScore()).isEqualTo(2);

    }

    @Test
    public void deleteReview() {

        Review review = reviewRepository.findByScore(4.5).get(0);
        reviewRepository.delete(review);
        List<Review> reviews = reviewRepository.findByScore(4.5);
        assertThat(reviews).hasSize(0);

    }

    //tests for appusers

    @Test
    public void findByUsernameReturnAppUser() {

        List<AppUser> users = appUserRepository.findByRole("USER");
        assertThat(users).hasSize(1);
        assertThat(users.get(0).getUsername()).isEqualTo("user");

    }

    @Test
    public void createNewAppUser() {

        AppUser user = new AppUser("testUser", "$2a$12$corF2r9EVdeYDi1qczkOh.fI3pFCGZjzvMV.kRTV1h/WZ/COlZ/De", "USER");
        appUserRepository.save(user);
        AppUser newUser = appUserRepository.findByRole("USER").get(1);
        assertThat(newUser.getId()).isNotNull();
        assertThat(newUser.getUsername()).isEqualTo("testUser");

    }

    @Test
    public void deleteAppUser() {

        List<AppUser> users = appUserRepository.findByRole("USER");
        appUserRepository.delete(users.get(0));
        assertThat(appUserRepository.findByRole("USER")).hasSize(0);

    }

}
