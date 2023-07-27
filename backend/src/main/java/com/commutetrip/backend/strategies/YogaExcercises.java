package com.commutetrip.backend.strategies;

import com.commutetrip.backend.services.TrainingTruckService;

public class YogaExcercises extends AbstractExcercises {
    public YogaExcercises(TrainingTruckService trainingTruckService) {
        super(trainingTruckService);
    }

    public String getExcercises() {
        return "";
    }

    public String getEquipment() {
        return "";
    }
}
