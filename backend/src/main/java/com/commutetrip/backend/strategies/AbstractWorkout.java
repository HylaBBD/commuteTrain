package com.commutetrip.backend.strategies;

import java.util.List;
import java.util.Optional;

import com.commutetrip.backend.models.Route;
import com.commutetrip.backend.models.TrainingTruck;
import com.commutetrip.backend.services.TrainingTruckService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
abstract class AbstractWorkout {
    private final TrainingTruckService trainingTruckService;
    private String exerciseType;

    public Optional<Route> getRoute(Long truckId) {
        Optional<TrainingTruck> trainingTruck = trainingTruckService.getTrainingTruck(truckId);
        return trainingTruck.map(TrainingTruck::route);
    }

    public void setExerciseType(String exerciseType) {
        this.exerciseType = exerciseType;
    }

    public String getExerciseType() {
        return exerciseType;
    }

    abstract public List getExercises();

    abstract public List getEquipment();
}
