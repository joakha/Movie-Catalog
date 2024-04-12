package com.packt.moviecatalog.web;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.packt.moviecatalog.domain.Director;
import com.packt.moviecatalog.domain.DirectorRepository;

@Controller
public class DirectorController {

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
    public String saveDirector(Director newDirector) {

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
