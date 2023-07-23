package com.commutetrip.backend.services;

import com.commutetrip.backend.database.entities.TruckRouteEntity;
import com.commutetrip.backend.models.Route;
import com.commutetrip.backend.models.TruckRoute;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.commutetrip.backend.database.services.TruckRouteDBService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    private List<TruckRoute> findAllTruckRoutes() {
        return truckRouteDBService.findAllTruckRoutes()
                .stream().map(this::mapTruckRoute)
                .collect(Collectors.toList());
    }

    private List<TruckRoute> findAllByRouteId(Long routeId) {
        return truckRouteDBService.findAllByRouteId(routeId)
                .stream().map(this::mapTruckRoute)
                .collect(Collectors.toList());
    }

    public List<TruckRoute> findTruckRoutes(Long routeId) {
        if(routeId != null) {
            return findAllByRouteId(routeId);
        } else {
            return findAllTruckRoutes();
        }
    }

    public Optional<TruckRoute> getTruckRouteById(Long truckRouteId) {
        return truckRouteDBService.findByTruckRouteId(truckRouteId)
                .map(this::mapTruckRoute);
    }
}
