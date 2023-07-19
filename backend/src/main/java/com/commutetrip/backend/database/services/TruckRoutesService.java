package com.commutetrip.backend.database.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import com.commutetrip.backend.database.repositories.TruckRoutesRepository;
import com.commutetrip.backend.database.entities.TruckRoutesEntity;

@Service
public class TruckRoutesService {
    private TruckRoutesRepository repository;

    @Autowired
    public TruckRoutesService(TruckRoutesRepository repository) {
        this.repository = repository;
    }

    public TruckRoutesEntity saveTruckRoute(TruckRoutesEntity truckRoute) {
        return repository.saveAndFlush(truckRoute);
    }

    public List<TruckRoutesEntity> findAllTruckRoutes() {
        return repository.findAll();
    }

    public Optional<TruckRoutesEntity> findByTruckRouteId(Long truckRouteId) {
        return repository.findByTruckRouteId(truckRouteId);
    }

    public List<TruckRoutesEntity> findAllByRouteId(Long routeId) {
        return repository.findAllByRouteId(routeId);
    }

    public List<TruckRoutesEntity> findAllByPickupTime(Timestamp pickupTime) {
        return repository.findAllByPickupTime(pickupTime);
    }

    public List<TruckRoutesEntity> findAllByDropOffTime(Timestamp dropOffTime) {
        return repository.findAllByDropOffTime(dropOffTime);
    }
}
