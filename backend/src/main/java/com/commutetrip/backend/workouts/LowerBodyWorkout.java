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
public class LowerBodyWorkout implements Workout {
    private final ExercisesService exercisesService;
    private final EquipmentService equipmentService;

    public List<Exercises> getExercises() {
        List<Exercises> allExercises = new ArrayList<>();
        allExercises.addAll(exercisesService.findAllByCategory("Legs"));
        return allExercises;
    }

    public List<Equipment> getEquipment() {
        List<Equipment> allEquipment = new ArrayList<>();
        allEquipment.addAll(equipmentService.findAllByMuscle("Legs"));
        allEquipment.addAll(equipmentService.findAllByMuscle("Calves"));
        return allEquipment;
    }

    public TruckWorkouts getWorkouts() {
        String WORKOUT_TYPE = "LowerBody";
        return new TruckWorkouts(
                WORKOUT_TYPE,
                getExercises(),
                getEquipment()
        );
    }
}
