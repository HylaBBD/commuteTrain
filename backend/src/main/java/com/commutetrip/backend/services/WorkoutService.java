package com.commutetrip.backend.services;

import com.commutetrip.backend.models.CommuterBooking;
import com.commutetrip.backend.models.TrainingTruck;
import com.commutetrip.backend.models.TruckRoute;
import com.commutetrip.backend.models.TruckWorkouts;
import com.commutetrip.backend.workouts.WorkoutFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class WorkoutService {
    private final CommuterBookingService commuterBookingService;
    private final TrainingTruckService trainingTruckService;
    private final WorkoutFactory workoutFactory;

    public Optional<TruckWorkouts> getWorkout(Long bookingId) {
        Optional<CommuterBooking> commuterBooking = commuterBookingService.getBooking(bookingId);
        if(commuterBooking.isPresent()) {
            TruckRoute truckRoute = commuterBooking.get().truckRoute();
            Optional<TrainingTruck> trainingTruck = trainingTruckService.getTrainingTruckByTruckRouteId(truckRoute.truckRouteId());
            if(trainingTruck.isPresent()) {
                return Optional.of(workoutFactory.createWorkout(trainingTruck.get().type()));
            }
        }
        return Optional.empty();
    }
}
