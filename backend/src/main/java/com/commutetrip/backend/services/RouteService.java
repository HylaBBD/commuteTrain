package com.commutetrip.backend.services;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;

import com.commutetrip.backend.database.entities.RouteEntity;
import com.commutetrip.backend.database.services.RouteDBService;

import com.commutetrip.backend.models.Route;
import com.commutetrip.backend.models.TruckStop;

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

    private List<Route> findAllByStartingPoint(Long startingPoint) {
        return routeDBService.findAllByStartingPoint(startingPoint)
                .stream().map(this::mapRoute)
                .collect(Collectors.toList());
    }
    private List<Route> findAllRoutes() {
        return routeDBService.findAllRoutes()
                .stream().map(this::mapRoute)
                .collect(Collectors.toList());
    }

    private List<Route> findAllByEndPoint(Long endPoint) {
        return routeDBService.findAllByEndPoint(endPoint)
                .stream().map(this::mapRoute)
                .collect(Collectors.toList());
    }

    private List<Route> findAllByStartingPointAndEndPoint(Long startingPoint, Long endPoint) {
        return routeDBService.findAllByStartingPointAndEndPoint(startingPoint, endPoint)
                .stream().map(this::mapRoute)
                .collect(Collectors.toList());
    }

    public List<Route> findRoutes(Long startingPoint, Long endPoint) {
        if(startingPoint != null && endPoint != null) {
            return findAllByStartingPointAndEndPoint(startingPoint, endPoint);
        } else if (startingPoint != null) {
            return findAllByStartingPoint(startingPoint);
        } else if (endPoint != null) {
            return findAllByEndPoint(endPoint);
        } else {
            return findAllRoutes();
        }
    }
    public Optional<Route> getRouteById(Long routeId) {
        return routeDBService.findByRouteId(routeId).map(this::mapRoute);
    }
}
