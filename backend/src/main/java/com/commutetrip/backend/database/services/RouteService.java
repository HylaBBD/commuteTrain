package com.commutetrip.backend.database.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.commutetrip.backend.database.repositories.RouteRepository;
import com.commutetrip.backend.database.entities.RouteEntity;

@Service
public class RouteService {
    private RouteRepository repository;

    @Autowired
    public RouteService(RouteRepository repository) {
        this.repository = repository;
    }

    public RouteEntity saveRoute(RouteEntity route) {
        return repository.saveAndFlush(route);
    }

    public List<RouteEntity> findAllRoutes() {
        return repository.findAll();
    }

    public Optional<RouteEntity> findByRouteId(Long routeId) {
        return repository.findByRouteId(routeId);
    }

    public List<RouteEntity> findAllByStartingPoint(Long startingPoint) {
        return repository.findAllByStartingPoint(startingPoint);
    }

    public List<RouteEntity> findAllByEndPoint(Long endPoint) {
        return repository.findAllByEndPoint(endPoint);
    }

    public Optional<RouteEntity> findByStartingPointAndEndPoint(Long startingPoint, Long endPoint) {
        return repository.findByStartingPointAndEndPoint(startingPoint, endPoint);
    }
}
