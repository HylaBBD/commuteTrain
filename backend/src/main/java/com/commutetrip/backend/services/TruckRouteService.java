package com.commutetrip.backend.services;

import com.commutetrip.backend.database.entities.TruckRouteEntity;
import com.commutetrip.backend.models.Route;
import com.commutetrip.backend.models.TruckRoute;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.commutetrip.backend.database.services.TruckRouteDBService;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TruckRouteService {
    private final TruckRouteDBService truckRouteDBService;
    private final RouteService routeService;

    private TruckRoute mapTruckRoute(TruckRouteEntity truckRoute) {
        Optional<Route> route = routeService.getRouteById(truckRoute.getRouteId());
        return new TruckRoute(
                truckRoute.getTruckRouteId(),
                route.orElseThrow(),
                truckRoute.getPickupTime(),
                truckRoute.getDropOffTime()
        );
    }

    public TruckRouteEntity saveTruckRoute(TruckRouteEntity truckRoute) {
        return truckRouteDBService.saveTruckRoute(truckRoute);
    }

    public List<TruckRouteEntity> findAllTruckRoutes() {
        return truckRouteDBService.findAllTruckRoutes();
    }

    public Optional<TruckRouteEntity> findByTruckRouteId(Long truckRouteId) {
        return truckRouteDBService.findByTruckRouteId(truckRouteId);
    }

    public List<TruckRouteEntity> findAllByRouteId(Long routeId) {
        return truckRouteDBService.findAllByRouteId(routeId);
    }

    public List<TruckRouteEntity> findAllByPickupTime(Timestamp pickupTime) {
        return truckRouteDBService.findAllByPickupTime(pickupTime);
    }

    public List<TruckRouteEntity> findAllByDropOffTime(Timestamp dropOffTime) {
        return truckRouteDBService.findAllByDropOffTime(dropOffTime);
    }

    public Optional<TruckRoute> getTruckRoute(Long truckRouteId) {
        return findByTruckRouteId(truckRouteId)
                .map(this::mapTruckRoute);
    }
}
