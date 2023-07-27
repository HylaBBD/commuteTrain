package com.commutetrip.backend.services;

import com.commutetrip.backend.database.entities.ExercisesEntity;
import com.commutetrip.backend.database.services.ExercisesDBService;
import com.commutetrip.backend.models.Exercises;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ExercisesService {
    private final ExercisesDBService exercisesDBService;

    private Exercises mapExercises(ExercisesEntity exercisesEntity) {
        return new Exercises(
                exercisesEntity.getExercisesId(),
                exercisesEntity.getName(),
                exercisesEntity.getCategory()
        );
    }
    public List<Exercises> findAllByName(String name) {
        return exercisesDBService.findAllByName(name)
                .stream().map(this::mapExercises)
                .collect(Collectors.toList());
    }

    public List<Exercises> findAllByCategory(String category) {
        return exercisesDBService.findAllByCategory(category)
                .stream().map(this::mapExercises)
                .collect(Collectors.toList());
    }

    public Optional<Exercises> findByExercisesId(Long exercisesId) {
        return exercisesDBService.findByExercisesId(exercisesId)
                .map(this::mapExercises);
    }
}
