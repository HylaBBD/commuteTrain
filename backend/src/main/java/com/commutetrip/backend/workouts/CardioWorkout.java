package com.commutetrip.backend.workouts;

import com.commutetrip.backend.models.Equipment;
import com.commutetrip.backend.models.Exercises;
import com.commutetrip.backend.models.TruckWorkouts;
import com.commutetrip.backend.services.EquipmentService;
import com.commutetrip.backend.services.ExercisesService;

import java.util.ArrayList;
import java.util.List;
public class CardioWorkout implements Workout {

    private final ExercisesService exercisesService;
    private final EquipmentService equipmentService;

    public CardioWorkout(ExercisesService exercisesService, EquipmentService equipmentService) {
        this.exercisesService = exercisesService;
        this.equipmentService = equipmentService;
    }

    public List<Exercises> getExercises() {
        List<Exercises> allExercises = new ArrayList<>();
        allExercises.addAll(exercisesService.findAllByCategory("Cardio"));
        return allExercises;
    }

    public List<Equipment> getEquipment() {
        List<Equipment> allEquipment = new ArrayList<>();
        allEquipment.addAll(equipmentService.findAllByMuscle("Legs"));
        return allEquipment;
    }

    public TruckWorkouts getWorkouts() {
        String WORKOUT_TYPE = "Cardio";
        return new TruckWorkouts(
                WORKOUT_TYPE,
                getExercises(),
                getEquipment()
        );
    }
}
