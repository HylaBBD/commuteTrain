package com.commutetrip.backend.services;

import com.commutetrip.backend.database.entities.TruckRouteEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.commutetrip.backend.database.services.TruckRouteDBService;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TruckRouteService {
    private final TruckRouteDBService service;

    public TruckRouteEntity saveTruckRoute(TruckRouteEntity truckRoute) {
        return service.saveTruckRoute(truckRoute);
    }

    public List<TruckRouteEntity> findAllTruckRoutes() {
        return service.findAllTruckRoutes();
    }

    public Optional<TruckRouteEntity> findByTruckRouteId(Long truckRouteId) {
        return service.findByTruckRouteId(truckRouteId);
    }

    public List<TruckRouteEntity> findAllByRouteId(Long routeId) {
        return service.findAllByRouteId(routeId);
    }

    public List<TruckRouteEntity> findAllByPickupTime(Timestamp pickupTime) {
        return service.findAllByPickupTime(pickupTime);
    }

    public List<TruckRouteEntity> findAllByDropOffTime(Timestamp dropOffTime) {
        return service.findAllByDropOffTime(dropOffTime);
    }
}
