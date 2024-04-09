package com.packt.moviecatalog.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.packt.moviecatalog.domain.DirectorRepository;

@Controller
public class DirectorController {

    @Autowired
    private DirectorRepository directorRepository;

    @GetMapping("/directorlist")
    public String directorlist(Model model) {

        model.addAttribute("directors", directorRepository.findAll());

        return "directorlist";

    }

	@GetMapping("/deletedirector/{id}")
	public String deleteBook(@PathVariable("id") Long directorid) {
		directorRepository.deleteById(directorid);
		return "redirect:/directorlist";

	}
    
}
