package com.commutetrip.backend.database.repositories.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import com.commutetrip.backend.database.repositories.TruckRouteRepository;
import com.commutetrip.backend.database.entities.TruckRouteEntity;

@Service
public class TruckRouteRepositoryImpl {
    private TruckRouteRepository repository;

    @Autowired
    public TruckRouteRepositoryImpl(TruckRouteRepository repository) {
        this.repository = repository;
    }

    public TruckRouteEntity saveTruckRoute(TruckRouteEntity truckRoute) {
        return repository.saveAndFlush(truckRoute);
    }

    public List<TruckRouteEntity> findAllTruckRoutes() {
        return repository.findAll();
    }

    public Optional<TruckRouteEntity> findByTruckRouteId(Long truckRouteId) {
        return repository.findByTruckRouteId(truckRouteId);
    }

    public List<TruckRouteEntity> findAllByRouteId(Long routeId) {
        return repository.findAllByRouteId(routeId);
    }

    public List<TruckRouteEntity> findAllByPickupTime(Timestamp pickupTime) {
        return repository.findAllByPickupTime(pickupTime);
    }

    public List<TruckRouteEntity> findAllByDropOffTime(Timestamp dropOffTime) {
        return repository.findAllByDropOffTime(dropOffTime);
    }
}
