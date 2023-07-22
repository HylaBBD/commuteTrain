package com.commutetrip.backend.services;

import com.commutetrip.backend.database.entities.TrainingTruckEntity;
import com.commutetrip.backend.models.Route;
import com.commutetrip.backend.models.TrainingTruck;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.commutetrip.backend.database.repositories.impl.TrainingTruckRepositoryImpl;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TrainingTruckService {
    private final TrainingTruckRepositoryImpl trainingTruckRepository;
    private final RouteService routeService;

    private TrainingTruck mapTrainingTruck(TrainingTruckEntity trainingTruck) {
        Optional<Route> route = routeService.getRoute(trainingTruck.getRouteId());
        return new TrainingTruck(
                trainingTruck.getTruckId(),
                route.orElseThrow()
        );
    }

    public TrainingTruckEntity saveTrainingTruck(TrainingTruckEntity trainingTruck) {
        return trainingTruckRepository.saveTrainingTruck(trainingTruck);
    }

    public List<TrainingTruckEntity> findAllTrainingTrucks() {
        return trainingTruckRepository.findAllTrainingTrucks();
    }

    public Optional<TrainingTruckEntity> findByTruckId(Long truckId) {
        return trainingTruckRepository.findByTruckId(truckId);
    }

    public List<TrainingTruckEntity> findAllByRouteId(Long routeId) {
        return trainingTruckRepository.findAllByRouteId(routeId);
    }

    public Optional<TrainingTruck> getTrainingTruck(Long truckId) {
        return findByTruckId(truckId)
                .map(this::mapTrainingTruck);
    }
}
