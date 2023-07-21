package com.commutetrip.backend.models;

import lombok.Getter;

@Getter
public record TrainingTruck(Long truckId, Route route) {
}
