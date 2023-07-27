package com.commutetrip.backend.strategies;

import java.util.Optional;

import com.commutetrip.backend.models.Route;
import com.commutetrip.backend.models.TrainingTruck;
import com.commutetrip.backend.services.TrainingTruckService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
abstract class AbstractExcercises {
    private final TrainingTruckService trainingTruckService;
    private String excerciseType;

    public Optional<Route> getRoute(Long truckId) {
        Optional<TrainingTruck> trainingTruck = trainingTruckService.getTrainingTruck(truckId);
        return trainingTruck.map(TrainingTruck::route);
    }

    public void setExcerciseType(String excerciseType) {
        this.excerciseType = excerciseType;
    }

    abstract public String getExcercises();

    abstract public String getEquipment();
}
