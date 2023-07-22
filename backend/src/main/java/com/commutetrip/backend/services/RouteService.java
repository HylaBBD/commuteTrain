package com.commutetrip.backend.services;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import com.commutetrip.backend.database.entities.RouteEntity;
import com.commutetrip.backend.database.services.RouteDBService;
import com.commutetrip.backend.models.Route;
import com.commutetrip.backend.models.TruckStop;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RouteService {
    private final RouteDBService routeDBService;
    private final TruckStopService truckStopService;

    private Route mapRoute(RouteEntity route) {
        Optional<TruckStop> startingPoint = truckStopService.getTruckStop(route.getStartingPoint());
        Optional<TruckStop> endPoint = truckStopService.getTruckStop(route.getEndPoint());
        return new Route(
                route.getRouteId(),
                startingPoint.orElseThrow(),
                endPoint.orElseThrow()
        );
    }
    public RouteEntity saveRoute(RouteEntity route) {
        return routeDBService.saveRoute(route);
    }

    public List<RouteEntity> findAllRoutes() {
        return routeDBService.findAllRoutes();
    }

    public Optional<RouteEntity> findByRouteId(Long routeId) {
        return routeDBService.findByRouteId(routeId);
    }

    public List<RouteEntity> findAllByStartingPoint(Long startingPoint) {
        return routeDBService.findAllByStartingPoint(startingPoint);
    }

    public List<RouteEntity> findAllByEndPoint(Long endPoint) {
        return routeDBService.findAllByEndPoint(endPoint);
    }

    public Optional<RouteEntity> findByStartingPointAndEndPoint(Long startingPoint, Long endPoint) {
        return routeDBService.findByStartingPointAndEndPoint(startingPoint, endPoint);
    }

    public Optional<Route> getRoute(Long routeId) {
        return findByRouteId(routeId).map(this::mapRoute);
    }
}
