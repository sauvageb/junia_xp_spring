package com.junia.demo.controller.api;

import com.junia.demo.repository.entity.Tutorial;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class TutorialRestController {

    private List<Tutorial> tutorialList;

    public TutorialRestController() {
        tutorialList = new ArrayList<>();
        tutorialList.add(new Tutorial(1L, "Spring", LocalDate.now()));
    }

    @GetMapping("/api/tutorials/{id}")
    public ResponseEntity<Tutorial> fetchById(@PathVariable("id") Long id) {
        Optional<Tutorial> optTutorial = tutorialList
                .stream()
                .filter(t -> t.getId().equals(id))
                .findFirst();
        if (optTutorial.isPresent()) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(optTutorial.get());
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }

    }


    @GetMapping("/api/tutorials")
    public ResponseEntity<List<Tutorial>> getTutorials() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(tutorialList);
    }


}
