package com.commutetrip.backend.services;

import com.commutetrip.backend.database.entities.TrainingTruckEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.commutetrip.backend.database.services.TrainingTruckDBService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TrainingTruckService {
    private final TrainingTruckDBService service;

    public TrainingTruckEntity saveTrainingTruck(TrainingTruckEntity trainingTruck) {
        return service.saveTrainingTruck(trainingTruck);
    }

    public List<TrainingTruckEntity> findAllTrainingTrucks() {
        return service.findAllTrainingTrucks();
    }

    public Optional<TrainingTruckEntity> findByTruckId(Long truckId) {
        return service.findByTruckId(truckId);
    }

    public List<TrainingTruckEntity> findAllByRouteId(Long routeId) {
        return service.findAllByRouteId(routeId);
    }
}
