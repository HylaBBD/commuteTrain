package com.commutetrip.backend.workouts;

import com.commutetrip.backend.models.Equipment;
import com.commutetrip.backend.models.Exercises;
import com.commutetrip.backend.models.TruckWorkouts;

import java.util.List;

public interface Workout {
    List<Exercises> getExercises();
    List<Equipment> getEquipment();
    TruckWorkouts getWorkouts();
}
