package com.junia.demo.repository;

import com.junia.demo.repository.entity.Tutorial;
import org.springframework.data.repository.CrudRepository;

public interface TutorialRepository extends CrudRepository<Tutorial, Long> {
}
