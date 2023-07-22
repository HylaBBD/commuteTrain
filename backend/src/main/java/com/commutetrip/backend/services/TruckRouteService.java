package com.commutetrip.backend.services;

import com.commutetrip.backend.database.entities.TruckRouteEntity;
import com.commutetrip.backend.models.Route;
import com.commutetrip.backend.models.TruckRoute;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.commutetrip.backend.database.repositories.impl.TruckRouteRepositoryImpl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TruckRouteService {
    private final TruckRouteRepositoryImpl truckRouteRepository;
    private final RouteService routeService;

    private TruckRoute mapTruckRoute(TruckRouteEntity truckRoute) {
        Optional<Route> route = routeService.getRoute(truckRoute.getRouteId());
        return new TruckRoute(
                truckRoute.getTruckRouteId(),
                route.orElseThrow(),
                truckRoute.getPickupTime(),
                truckRoute.getDropOffTime()
        );
    }

    public TruckRouteEntity saveTruckRoute(TruckRouteEntity truckRoute) {
        return truckRouteRepository.saveTruckRoute(truckRoute);
    }

    public List<TruckRouteEntity> findAllTruckRoutes() {
        return truckRouteRepository.findAllTruckRoutes();
    }

    public Optional<TruckRouteEntity> findByTruckRouteId(Long truckRouteId) {
        return truckRouteRepository.findByTruckRouteId(truckRouteId);
    }

    public List<TruckRouteEntity> findAllByRouteId(Long routeId) {
        return truckRouteRepository.findAllByRouteId(routeId);
    }

    public List<TruckRouteEntity> findAllByPickupTime(Timestamp pickupTime) {
        return truckRouteRepository.findAllByPickupTime(pickupTime);
    }

    public List<TruckRouteEntity> findAllByDropOffTime(Timestamp dropOffTime) {
        return truckRouteRepository.findAllByDropOffTime(dropOffTime);
    }

    public Optional<TruckRoute> getTruckRoute(Long truckRouteId) {
        return findByTruckRouteId(truckRouteId)
                .map(this::mapTruckRoute);
    }
}
