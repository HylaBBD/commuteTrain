package com.commutetrip.backend.strategies;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.commutetrip.backend.models.Equipment;
import com.commutetrip.backend.models.Exercises;
import com.commutetrip.backend.services.EquipmentService;
import com.commutetrip.backend.services.ExercisesService;
import com.commutetrip.backend.services.TrainingTruckService;

public class CircuitWorkout extends AbstractWorkout {
    private ExercisesService exercisesService;
    private EquipmentService equipmentService;

    @Autowired
    public CircuitWorkout(TrainingTruckService trainingTruckService) {
        super(trainingTruckService);
    }

    public List<Exercises> getExercises() {
        List<Exercises> allExercises = new ArrayList<Exercises>();

        allExercises.addAll(exercisesService.findAllByCategory("Cardio"));
        allExercises.addAll(exercisesService.findAllByCategory("Arms"));
        allExercises.addAll(exercisesService.findAllByCategory("Back"));
        allExercises.addAll(exercisesService.findAllByCategory("Chest"));
        allExercises.addAll(exercisesService.findAllByCategory("Legs"));

        return allExercises;
    }

    public List<Equipment> getEquipment() {
        List<Equipment> allEquipment = new ArrayList<Equipment>();

        allEquipment.addAll(equipmentService.findAllByMuscle("Multiple"));
        allEquipment.addAll(equipmentService.findAllByMuscle("Chest"));
        allEquipment.addAll(equipmentService.findAllByMuscle("Back"));
        allEquipment.addAll(equipmentService.findAllByMuscle("Legs"));
        allEquipment.addAll(equipmentService.findAllByMuscle("Calves"));

        return allEquipment;
    }
}
