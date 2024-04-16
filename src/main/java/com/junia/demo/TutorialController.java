package com.junia.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TutorialController {

    // Création d'une liste de tutorials
    private List<Tutorial> tutorialList;

    public TutorialController() {
        tutorialList = new ArrayList<>();
        tutorialList.add(new Tutorial(1L, "Spring", LocalDate.now()));
    }

    @GetMapping("/tutorials/add")
    public String displayAddForm(Model model) {
        model.addAttribute("newTuto", new Tutorial());
        return "add-tutorial";
    }

    @PostMapping("/tutorials/add")
    public String submitAddForm(Tutorial tutorial) {
        tutorial.setId(tutorialList.size() + 1L);
        tutorialList.add(tutorial);
        System.out.println(tutorial.getName());
        System.out.println(tutorial.getCreatedDate());
        return "redirect:/tutorials";
    }


    @GetMapping("/tutorials") // Défini l'url /tutorials
    public String displayTutorialList(Model model) {
        // Ajout de mes données dans la vue (Model)
        model.addAttribute("tutos", tutorialList);
        // Affiche la page tutoList
        return "tutoList";
    }


}
