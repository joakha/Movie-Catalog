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
import com.packt.moviecatalog.service.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RestController {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private DirectorRepository directorRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MovieService movieService;

    @GetMapping("/api/movies")
    public @ResponseBody Iterable<Movie> getMovies() {

        return movieService.findAllMoviesSorted();

    }

    @GetMapping("/api/movies/findByGenre/{genre}")
    public @ResponseBody List<Movie> getMoviesByGenre(@PathVariable String genre) {

        return (List<Movie>) movieRepository.findByGenre(genre);

    }

    @GetMapping("/api/movies/findByTitle/{title}")
    public @ResponseBody List<Movie> getMoviesByTitle(@PathVariable String title) {

        return (List<Movie>) movieRepository.findByTitle(title);

    }
    

    @GetMapping("/api/directors")
    public @ResponseBody List<Director> getDirectors() {

        return (List<Director>) directorRepository.findAll();

    }

    @GetMapping("/api/reviews")
    public @ResponseBody List<Review> getReviews() {

        return (List<Review>) reviewRepository.findAll();

    }
    
}
