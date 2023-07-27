package com.commutetrip.backend.strategies;

import org.springframework.beans.factory.annotation.Autowired;

import com.commutetrip.backend.services.TrainingTruckService;

public class CircuitExcercises extends AbstractExcercises {
    @Autowired
    public CircuitExcercises(TrainingTruckService trainingTruckService) {
        super(trainingTruckService);
    }

    public String getExcercises() {

        return "";
    }

    public String getEquipment() {
        return "";
    }
}
