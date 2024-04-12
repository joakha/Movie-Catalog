package com.packt.moviecatalog.web;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.packt.moviecatalog.domain.MovieRepository;
import com.packt.moviecatalog.domain.Review;
import com.packt.moviecatalog.domain.ReviewRepository;

@Controller
public class ReviewController {

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
    public String saveReview(Review newReview) {

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
