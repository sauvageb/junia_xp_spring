package com.junia.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TutorialController {


    @GetMapping("/tutorials") // Défini l'url /tutorials
    public String displayTutorialList(Model model) {

        // Création d'une liste de tutorials
        List<Tutorial> tutorialList = new ArrayList<>();
        tutorialList.add(new Tutorial(1L, "Spring", LocalDate.now()));

        // Ajout de mes données dans la vue (Model)
        model.addAttribute("tutos", tutorialList);

        // Affiche la page tutoList
        return "tutoList";
    }

    // Mettre en place l'ajout d'un tutorial

}
