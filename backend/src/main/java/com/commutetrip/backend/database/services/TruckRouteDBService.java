package com.commutetrip.backend.database.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import com.commutetrip.backend.database.repositories.TruckRouteRepository;
import com.commutetrip.backend.database.entities.TruckRouteEntity;

@Service
public class TruckRouteDBService {
    private TruckRouteRepository repository;

    @Autowired
    public TruckRouteDBService(TruckRouteRepository repository) {
        this.repository = repository;
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
