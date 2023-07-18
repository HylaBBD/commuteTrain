package com.commutetrip.backend.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import com.commutetrip.backend.database.entities.TruckStopEntity;

@Repository
public interface TruckStopRepository extends JpaRepository<TruckStopEntity, Long> {
    Optional<TruckStopEntity> findByStopId(Long stopId);
}
