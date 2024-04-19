package com.junia.demo.controller;

import com.junia.demo.repository.TutorialRepository;
import com.junia.demo.repository.entity.Tutorial;
import com.junia.demo.service.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TutorialController {

    @Autowired
    private TutorialService tutorialService;

    @GetMapping("/tutorials/add")
    public String displayAddForm(Model model) {
        model.addAttribute("newTuto", new Tutorial());
        return "add-tutorial";
    }

    @PostMapping("/tutorials/add")
    public String submitAddForm(Tutorial tutorial) {
        tutorialService.addTutorial(tutorial);
        return "redirect:/tutorials";
    }

    @GetMapping("/tutorials") // Défini l'url /tutorials
    public String displayTutorialList(Model model) {
        List<Tutorial> tutorialList = tutorialService.fetchTutorials();

        // Ajout de mes données dans la vue (Model)
        model.addAttribute("tutos", tutorialList);
        // Affiche la page tutoList
        return "tutoList";
    }


}
