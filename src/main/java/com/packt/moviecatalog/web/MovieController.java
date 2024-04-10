package com.packt.moviecatalog.web;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.packt.moviecatalog.domain.DirectorRepository;
import com.packt.moviecatalog.domain.Movie;
import com.packt.moviecatalog.domain.MovieRepository;
import org.springframework.ui.Model;

@Controller
public class MovieController {

    private boolean editing;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private DirectorRepository directorRepository;

    @GetMapping("/frontpage")
    public String frontpage() {

        return "catalogfrontpage";

    }

    @GetMapping("/movielist")
    public String movielist(Model model) {

        model.addAttribute("movies", movieRepository.findAll());

        return "movielist";

    }

    @GetMapping("/addmovie")
    public String addMovie(Model model) {

        editing = false;
        model.addAttribute("editing", editing);
        model.addAttribute("movie", new Movie());
        model.addAttribute("directors", directorRepository.findAll());

        return "movieform";

    }

    @PostMapping("/addmovie")
    public String saveMovie(Movie newMovie) {

        movieRepository.save(newMovie);

        return "redirect:/movielist";

    }

    @GetMapping("/editmovie/{id}")
	public String editMovie(@PathVariable("id") Long movieId, Model model) {

		Optional<Movie> movieToEdit = movieRepository.findById(movieId);
        editing = true;
        model.addAttribute("editing", editing);
        model.addAttribute("movie", movieToEdit);
        model.addAttribute("directors", directorRepository.findAll());

		return "movieform";

	}

    @GetMapping("/deletemovie/{id}")
    public String deleteMovie(@PathVariable("id") Long movieid) {
        
        movieRepository.deleteById(movieid);
        return "redirect:/movielist";

    }

}
