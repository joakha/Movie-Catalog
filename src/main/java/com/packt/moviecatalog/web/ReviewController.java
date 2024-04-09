package com.packt.moviecatalog.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.packt.moviecatalog.domain.ReviewRepository;

@Controller
public class ReviewController {

    @Autowired
    private ReviewRepository reviewRepository;

    @GetMapping("/reviewlist")
    public String reviewlist(Model model) {

        model.addAttribute("reviews", reviewRepository.findAll());

        return "reviewlist";

    }

	@GetMapping("/deletereview/{id}")
	public String deleteBook(@PathVariable("id") Long reviewid) {
		reviewRepository.deleteById(reviewid);
		return "redirect:/reviewlist";

	}
    
}
