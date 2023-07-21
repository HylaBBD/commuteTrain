package com.commutetrip.backend.services;

import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.commutetrip.backend.database.services.CommuterBookingDBService;
import com.commutetrip.backend.database.entities.CommuterBookingEntity;

@RequiredArgsConstructor
@Service
public class CommuterBookingService {
    private final CommuterBookingDBService service;

    public CommuterBookingEntity saveBooking(CommuterBookingEntity booking) {
        return service.saveBooking(booking);
    }

    public Optional<CommuterBookingEntity> findByBookingId(Long bookingId) {
        return service.findByBookingId(bookingId);
    }

    public List<CommuterBookingEntity> findAllByCommuterId(Long commuterId) {
        return service.findAllByCommuterId(commuterId);
    }

    public List<CommuterBookingEntity> findAllByTruckRouteId(Long truckRouteId) {
        return service.findAllByTruckRouteId(truckRouteId);
    }

    public List<CommuterBookingEntity> findAllByCommuterIdAndTruckRouteId(Long commuterId, Long truckRouteId) {
        return service.findAllByCommuterIdAndTruckRouteId(commuterId, truckRouteId);
    }
}
