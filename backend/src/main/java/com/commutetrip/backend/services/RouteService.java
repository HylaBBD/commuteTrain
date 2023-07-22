package com.commutetrip.backend.services;

import java.util.List;
import java.util.Optional;

import com.commutetrip.backend.database.entities.RouteEntity;
import com.commutetrip.backend.database.repositories.impl.RouteRepositoryImpl;
import com.commutetrip.backend.models.Route;
import com.commutetrip.backend.models.TruckStop;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RouteService {
    private final RouteRepositoryImpl routeRepository;
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
        return routeRepository.saveRoute(route);
    }

    public List<RouteEntity> findAllRoutes() {
        return routeRepository.findAllRoutes();
    }

    public Optional<RouteEntity> findByRouteId(Long routeId) {
        return routeRepository.findByRouteId(routeId);
    }

    public List<RouteEntity> findAllByStartingPoint(Long startingPoint) {
        return routeRepository.findAllByStartingPoint(startingPoint);
    }

    public List<RouteEntity> findAllByEndPoint(Long endPoint) {
        return routeRepository.findAllByEndPoint(endPoint);
    }

    public Optional<RouteEntity> findByStartingPointAndEndPoint(Long startingPoint, Long endPoint) {
        return routeRepository.findByStartingPointAndEndPoint(startingPoint, endPoint);
    }

    public Optional<Route> getRoute(Long routeId) {
        return findByRouteId(routeId).map(this::mapRoute);
    }
}
