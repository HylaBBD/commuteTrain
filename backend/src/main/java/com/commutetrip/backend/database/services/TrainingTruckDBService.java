package com.commutetrip.backend.database.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.commutetrip.backend.database.repositories.TrainingTruckRepository;
import com.commutetrip.backend.database.entities.TrainingTruckEntity;

@Service
public class TrainingTruckDBService {
    private TrainingTruckRepository repository;

    @Autowired
    public TrainingTruckDBService(TrainingTruckRepository repository) {
        this.repository = repository;
    }

    public List<TrainingTruckEntity> findAllTrainingTrucks() {
        return repository.findAll();
    }

    public Optional<TrainingTruckEntity> findByTruckId(Long truckId) {
        return repository.findByTruckId(truckId);
    }

    public List<TrainingTruckEntity> findAllByRouteId(Long routeId) {
        return repository.findAllByRouteId(routeId);
    }
}
