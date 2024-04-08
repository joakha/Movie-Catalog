package com.packt.moviecatalog.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.packt.moviecatalog.domain.MovieRepository;
import org.springframework.ui.Model;

@Controller
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/frontpage")
    public String frontpage() {

        return "catalogfrontpage";

    }
    
    @GetMapping("/movielist")
    public String movielist(Model model) {

        model.addAttribute("movies", movieRepository.findAll());

        return "movielist";

    }

}
