package com.commutetrip.backend.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

import com.commutetrip.backend.database.entities.CommuterBookingEntity;

@Repository
public interface CommuterBookingRepository extends JpaRepository<CommuterBookingEntity, Long> {
    Optional<CommuterBookingEntity> findByBookingId(Long bookingId);
    List<CommuterBookingEntity> findAllByCommuterId(Long commuterId);
    List<CommuterBookingEntity> findAllByTruckRouteId(Long truckRouteId);
    List<CommuterBookingEntity> findAllByCommuterIdAndTruckRouteId(Long commuterId, Long truckRouteId);
}
