package com.commutetrip.backend.database.services;

import com.commutetrip.backend.database.entities.ExercisesEntity;
import com.commutetrip.backend.database.repositories.ExercisesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ExercisesDBService {
    private final ExercisesRepository repository;

    @Autowired
    public ExercisesDBService(ExercisesRepository repository) {
        this.repository = repository;
    }

    public List<ExercisesEntity> findAllByName(String name) {
        return repository.findAllByName(name);
    }

    public List<ExercisesEntity> findAllByCategory(String category) {
        return repository.findAllByCategory(category);
    }

    public Optional<ExercisesEntity> findByExercisesId(Long exercisesId) {
        return repository.findByExercisesId(exercisesId);
    }
}
