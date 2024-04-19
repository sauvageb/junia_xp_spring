package com.junia.demo.controller.api;

import com.junia.demo.repository.entity.Tutorial;
import com.junia.demo.service.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tutorials")
public class TutorialRestController {

    @Autowired
    private TutorialService tutorialService;

    @GetMapping("/{id}")
    public ResponseEntity<Tutorial> fetchById(@PathVariable("id") Long id) {

        Optional<Tutorial> optTutorial = tutorialService.fetchById(id);

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

    @GetMapping
    public ResponseEntity<List<Tutorial>> getTutorials() {
        List<Tutorial> tutorialList = tutorialService.fetchTutorials();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(tutorialList);
    }

    @PostMapping
    public ResponseEntity<Tutorial> addTutorial(@RequestBody Tutorial tuto) {

        Tutorial createdTuto = tutorialService.addTutorial(tuto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdTuto);
    }


}
