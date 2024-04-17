package com.packt.moviecatalog.web;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.packt.moviecatalog.domain.Director;
import com.packt.moviecatalog.domain.DirectorRepository;
import jakarta.validation.Valid;

@Controller
public class DirectorController {

    //this variable is used to change the h1 element of the directorform depending on whether a new director is being created or an existing one is being edited
    private boolean editing;

    @Autowired
    private DirectorRepository directorRepository;

    @GetMapping("/directorlist")
    public String directorlist(Model model) {

        model.addAttribute("directors", directorRepository.findAll());

        return "directorlist";

    }

    @GetMapping("/adddirector")
    public String addDirector(Model model) {

        editing = false;
        model.addAttribute("editing", editing);
        model.addAttribute("director", new Director());

        return "directorform";

    }

    @PostMapping("/adddirector")
    public String saveDirector(@Valid Director newDirector, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {

            model.addAttribute("editing", editing);

        	return "directorform";

        }

        directorRepository.save(newDirector);

        return "redirect:/directorlist";

    }

    @GetMapping("/editdirector/{id}")
	public String editDirector(@PathVariable("id") Long directorId, Model model) {

		Optional<Director> directorToEdit = directorRepository.findById(directorId);
        editing = true;
        model.addAttribute("editing", editing);
        model.addAttribute("director", directorToEdit);

		return "directorform";

	}

	@GetMapping("/deletedirector/{id}")
	public String deleteDirector(@PathVariable("id") Long directorid) {

		directorRepository.deleteById(directorid);
		return "redirect:/directorlist";

	}
    
}
