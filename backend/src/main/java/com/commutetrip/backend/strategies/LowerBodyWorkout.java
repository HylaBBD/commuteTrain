package com.commutetrip.backend.strategies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.commutetrip.backend.models.Equipment;
import com.commutetrip.backend.models.Exercises;
import com.commutetrip.backend.services.EquipmentService;
import com.commutetrip.backend.services.ExercisesService;
import com.commutetrip.backend.services.TrainingTruckService;

public class LowerBodyWorkout extends AbstractWorkout {
    private ExercisesService exercisesService;
    private EquipmentService equipmentService;

    @Autowired
    public LowerBodyWorkout(TrainingTruckService trainingTruckService) {
        super(trainingTruckService);
    }

    public List<Exercises> getExercises() {
        List<Exercises> cardios = exercisesService.findAllByCategory("Legs");
        return cardios;
    }

    public List<Equipment> getEquipment() {
        List<Equipment> equipment = equipmentService.findAllByMuscle("Legs");
        return equipment;
    }
}
