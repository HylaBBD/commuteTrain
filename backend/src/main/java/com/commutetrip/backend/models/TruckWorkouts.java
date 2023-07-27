package com.commutetrip.backend.models;

import java.util.List;

public record TruckWorkouts(String exerciseType, List<Exercises> exercises, List<Equipment> equipment) {

}
