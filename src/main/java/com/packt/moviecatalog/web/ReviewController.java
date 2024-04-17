package com.packt.moviecatalog.web;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.packt.moviecatalog.domain.MovieRepository;
import com.packt.moviecatalog.domain.Review;
import com.packt.moviecatalog.domain.ReviewRepository;
import jakarta.validation.Valid;

@Controller
public class ReviewController {

    //this variable is used to change the h1 element of the reviewform depending on whether a new review is being created or an existing one is being edited
    private boolean editing;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/reviewlist")
    public String reviewlist(Model model) {

        model.addAttribute("reviews", reviewRepository.findAll());

        return "reviewlist";

    }

    @GetMapping("/addreview")
    public String addReview(Model model) {

        editing = false;
        model.addAttribute("editing", editing);
        model.addAttribute("review", new Review());
        model.addAttribute("movies", movieRepository.findAll());

        return "reviewform";

    }

    @PostMapping("/addreview")
    public String saveReview(@Valid Review newReview, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {

            model.addAttribute("editing", editing);
            model.addAttribute("movies", movieRepository.findAll());

            return "reviewform";

        }

        reviewRepository.save(newReview);

        return "redirect:/reviewlist";

    }

    @GetMapping("/editreview/{id}")
	public String editReview(@PathVariable("id") Long reviewId, Model model) {

		Optional<Review> reviewToEdit = reviewRepository.findById(reviewId);
        editing = true;
        model.addAttribute("editing", editing);
        model.addAttribute("review", reviewToEdit);
        model.addAttribute("movies", movieRepository.findAll());

		return "reviewform";

	}

	@GetMapping("/deletereview/{id}")
	public String deleteReview(@PathVariable("id") Long reviewid) {

		reviewRepository.deleteById(reviewid);
		return "redirect:/reviewlist";

	}
    
}
