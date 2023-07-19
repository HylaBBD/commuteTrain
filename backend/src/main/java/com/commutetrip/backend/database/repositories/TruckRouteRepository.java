package com.commutetrip.backend.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import com.commutetrip.backend.database.entities.TruckRouteEntity;

@Repository
public interface TruckRouteRepository extends JpaRepository<TruckRouteEntity, Long> {
    Optional<TruckRouteEntity> findByTruckRouteId(Long truckRouteId);
    List<TruckRouteEntity> findAllByRouteId(Long routeId);
    List<TruckRouteEntity> findAllByPickupTime(Timestamp pickupTime);
    List<TruckRouteEntity> findAllByDropOffTime(Timestamp dropOffTime);
}
