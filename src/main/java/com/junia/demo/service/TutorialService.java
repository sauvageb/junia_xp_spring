package com.junia.demo.service;

import com.junia.demo.repository.TutorialRepository;
import com.junia.demo.repository.entity.Tutorial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TutorialService {

    @Autowired
    private TutorialRepository tutorialRepository;

    public List<Tutorial> fetchTutorials() {
        return (List<Tutorial>) tutorialRepository.findAll();
    }

    public Tutorial addTutorial(Tutorial newTutorial) {
        return tutorialRepository.save(newTutorial);
    }


    public Optional<Tutorial> fetchById(Long id) {
        return tutorialRepository.findById(id);
    }
}
