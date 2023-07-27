package com.commutetrip.backend.database.repositories;

import com.commutetrip.backend.database.entities.ExercisesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExercisesRepository extends JpaRepository<ExercisesEntity, Long> {
    List<ExercisesEntity> findAllByName(String name);
    List<ExercisesEntity> findAllByCategory(String category);
    Optional<ExercisesEntity> findByExercisesId(Long exercisesId);
}
