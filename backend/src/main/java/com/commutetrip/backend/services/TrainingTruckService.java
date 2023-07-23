package com.commutetrip.backend.services;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;

import com.commutetrip.backend.database.services.TrainingTruckDBService;
import com.commutetrip.backend.database.entities.TrainingTruckEntity;

import com.commutetrip.backend.models.Route;
import com.commutetrip.backend.models.TrainingTruck;

@RequiredArgsConstructor
@Service
public class TrainingTruckService {
    private final TrainingTruckDBService trainingTruckDBService;
    private final RouteService routeService;

    private TrainingTruck mapTrainingTruck(TrainingTruckEntity trainingTruck) {
        Optional<Route> route = routeService.getRouteById(trainingTruck.getRouteId());
        return new TrainingTruck(
                trainingTruck.getTruckId(),
                route.orElseThrow()
        );
    }

    public List<TrainingTruckEntity> findAllTrainingTrucks() {
        return trainingTruckDBService.findAllTrainingTrucks();
    }

    public Optional<TrainingTruckEntity> findByTruckId(Long truckId) {
        return trainingTruckDBService.findByTruckId(truckId);
    }

    public List<TrainingTruckEntity> findAllByRouteId(Long routeId) {
        return trainingTruckDBService.findAllByRouteId(routeId);
    }

    public Optional<TrainingTruck> getTrainingTruck(Long truckId) {
        return findByTruckId(truckId)
                .map(this::mapTrainingTruck);
    }
}
