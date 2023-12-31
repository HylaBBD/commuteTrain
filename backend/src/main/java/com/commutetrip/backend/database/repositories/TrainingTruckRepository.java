package com.commutetrip.backend.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import com.commutetrip.backend.database.entities.TrainingTruckEntity;

@Repository
public interface TrainingTruckRepository extends JpaRepository<TrainingTruckEntity, Long> {
    Optional<TrainingTruckEntity> findByTruckRouteId(Long truckRouteId);
}
