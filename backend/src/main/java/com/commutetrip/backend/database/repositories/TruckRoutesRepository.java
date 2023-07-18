package com.commutetrip.backend.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import com.commutetrip.backend.database.entities.TruckRoutesEntity;

@Repository
public interface TruckRoutesRepository extends JpaRepository<TruckRoutesEntity, Long> {
    Optional<TruckRoutesEntity> findByTruckRouteId(Long truckRouteId);
    List<TruckRoutesEntity> findAllByRouteId(Long routeId);
    List<TruckRoutesEntity> findAllByPickupTime(Timestamp pickupTime);
    List<TruckRoutesEntity> findAllByDropOffTime(Timestamp dropOffTime);
}
