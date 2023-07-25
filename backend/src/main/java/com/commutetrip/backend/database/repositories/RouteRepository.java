package com.commutetrip.backend.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import com.commutetrip.backend.database.entities.RouteEntity;

@Repository
public interface RouteRepository extends JpaRepository<RouteEntity, Long> {
    Optional<RouteEntity> findByRouteId(Long routeId);
    List<RouteEntity> findAllByStartingPoint(Long startingPoint);
    List<RouteEntity> findAllByEndPoint(Long endPoint);
    List<RouteEntity> findAllByStartingPointAndEndPoint(Long startingPoint, Long endPoint);
}
