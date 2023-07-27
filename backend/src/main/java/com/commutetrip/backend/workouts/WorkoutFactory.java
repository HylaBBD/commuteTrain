package com.commutetrip.backend.workouts;

import com.commutetrip.backend.models.TruckWorkouts;
import com.commutetrip.backend.services.EquipmentService;
import com.commutetrip.backend.services.ExercisesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkoutFactory {

    private final ExercisesService exercisesService;
    private final EquipmentService equipmentService;

    @Autowired
    public WorkoutFactory(ExercisesService exercisesService, EquipmentService equipmentService) {
        this.exercisesService = exercisesService;
        this.equipmentService = equipmentService;
    }

    public TruckWorkouts createWorkout(String workoutType) {
        return switch (workoutType.toLowerCase()) {
            case "cardio":
                Workout cardioWorkout = new CardioWorkout(exercisesService, equipmentService);
                yield cardioWorkout.getWorkouts();
            case "circuit":
                Workout circuitWorkout = new CircuitWorkout(exercisesService, equipmentService);
                yield circuitWorkout.getWorkouts();
            case "lowerbody":
                Workout lowerBodyWorkout = new LowerBodyWorkout(exercisesService, equipmentService);
                yield lowerBodyWorkout.getWorkouts();
            case "upperbody":
                Workout upperBodyWorkout = new UpperBodyWorkout(exercisesService, equipmentService);
                yield upperBodyWorkout.getWorkouts();
            default:
                throw new IllegalArgumentException("No such workout");

        };
    }
}
