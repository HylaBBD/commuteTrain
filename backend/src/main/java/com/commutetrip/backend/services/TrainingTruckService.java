package com.commutetrip.backend.services;

import com.commutetrip.backend.models.TruckRoute;
import org.springframework.stereotype.Service;

import java.util.Optional;

import lombok.RequiredArgsConstructor;

import com.commutetrip.backend.database.services.TrainingTruckDBService;
import com.commutetrip.backend.database.entities.TrainingTruckEntity;

import com.commutetrip.backend.models.TrainingTruck;

@RequiredArgsConstructor
@Service
public class TrainingTruckService {
    private final TrainingTruckDBService trainingTruckDBService;
    private final TruckRouteService truckRouteService;

    private TrainingTruck mapTrainingTruck(TrainingTruckEntity trainingTruck) {
        Optional<TruckRoute> truckRoute = truckRouteService.getTruckRouteById(trainingTruck.getTruckRouteId());
        return new TrainingTruck(
                trainingTruck.getTruckId(),
                truckRoute.orElseThrow(),
                trainingTruck.getType()
        );
    }

    public Optional<TrainingTruck> getTrainingTruckByTruckRouteId(Long truckRouteId) {
        return trainingTruckDBService.findByTruckRouteId(truckRouteId)
                .map(this::mapTrainingTruck);
    }
}
