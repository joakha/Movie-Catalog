package com.packt.moviecatalog.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.packt.moviecatalog.domain.MovieRepository;
import com.packt.moviecatalog.domain.Review;
import com.packt.moviecatalog.domain.Director;
import com.packt.moviecatalog.domain.DirectorRepository;
import com.packt.moviecatalog.domain.Movie;
import com.packt.moviecatalog.domain.ReviewRepository;
import com.packt.moviecatalog.service.DirectorService;
import com.packt.moviecatalog.service.MovieService;
import com.packt.moviecatalog.service.ReviewService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RestController {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MovieService movieService;

    @Autowired
    private DirectorRepository directorRepository;

    @Autowired
    private DirectorService directorService;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired 
    private ReviewService reviewService;

    @GetMapping("/api/movies")
    public @ResponseBody Iterable<Movie> getMovies() {

        return movieService.findAllMoviesSorted();

    }

    @GetMapping("/api/movies/findByGenre/{genre}")
    public @ResponseBody List<Movie> getMoviesByGenre(@PathVariable String genre) {

        return (List<Movie>) movieRepository.findByGenreContainingIgnoreCase(genre);

    }

    @GetMapping("/api/movies/findByTitle/{title}")
    public @ResponseBody List<Movie> getMoviesByTitle(@PathVariable String title) {

        return (List<Movie>) movieRepository.findByTitleContainingIgnoreCase(title);

    }
    

    @GetMapping("/api/directors")
    public @ResponseBody Iterable<Director> getDirectors() {

        return directorService.findAllDirectorsSorted();

    }

    @GetMapping("/api/directors/findByName/{name}")
    public @ResponseBody List<Director> getDirectorsByName(@PathVariable String name) {

        return (List<Director>) directorRepository.findByNameContainingIgnoreCase(name);

    }

    @GetMapping("/api/reviews")
    public @ResponseBody Iterable<Review> getReviews() {

        return reviewService.findAllReviewsSorted();

    }

    @GetMapping("/api/reviews/findByScore/{score}")
    public @ResponseBody List<Review> getReviewsByScore(@PathVariable double score) {

        return (List<Review>) reviewRepository.findByScore(score);

    }
    
}
