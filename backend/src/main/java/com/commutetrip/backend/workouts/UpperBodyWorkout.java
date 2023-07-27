package com.commutetrip.backend.workouts;

import com.commutetrip.backend.models.Equipment;
import com.commutetrip.backend.models.Exercises;
import com.commutetrip.backend.models.TruckWorkouts;
import com.commutetrip.backend.services.EquipmentService;
import com.commutetrip.backend.services.ExercisesService;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class UpperBodyWorkout implements Workout {
    private final ExercisesService exercisesService;
    private final EquipmentService equipmentService;

    public List<Exercises> getExercises() {
        List<Exercises> allExercises = new ArrayList<>();
        allExercises.addAll(exercisesService.findAllByCategory("Arms"));
        allExercises.addAll(exercisesService.findAllByCategory("Back"));
        allExercises.addAll(exercisesService.findAllByCategory("Chest"));
        return allExercises;
    }

    public List<Equipment> getEquipment() {
        List<Equipment> allEquipment = new ArrayList<>();
        allEquipment.addAll(equipmentService.findAllByMuscle("Multiple"));
        allEquipment.addAll(equipmentService.findAllByMuscle("Chest"));
        allEquipment.addAll(equipmentService.findAllByMuscle("Back"));
        return allEquipment;
    }

    public TruckWorkouts getWorkouts() {
        String WORKOUT_TYPE = "UpperBody";
        return new TruckWorkouts(
                WORKOUT_TYPE,
                getExercises(),
                getEquipment()
        );
    }
}