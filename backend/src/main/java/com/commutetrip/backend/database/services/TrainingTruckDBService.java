package com.commutetrip.backend.database.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import com.commutetrip.backend.database.repositories.TrainingTruckRepository;
import com.commutetrip.backend.database.entities.TrainingTruckEntity;

@Service
public class TrainingTruckDBService {
    private final TrainingTruckRepository repository;

    @Autowired
    public TrainingTruckDBService(TrainingTruckRepository repository) {
        this.repository = repository;
    }

    public Optional<TrainingTruckEntity> findByTruckRouteId(Long truckRouteId) {
        return repository.findByTruckRouteId(truckRouteId);
    }
}
