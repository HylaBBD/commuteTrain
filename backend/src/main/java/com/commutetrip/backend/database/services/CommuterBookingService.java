package com.commutetrip.backend.database.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.commutetrip.backend.database.repositories.CommuterBookingRepository;
import com.commutetrip.backend.database.entities.CommuterBookingEntity;

@Service
public class CommuterBookingService {
    private CommuterBookingRepository repository;

    @Autowired
    public CommuterBookingService(CommuterBookingRepository commuterBookingRepository) {
        this.repository = commuterBookingRepository;
    }

    public CommuterBookingEntity saveBooking(CommuterBookingEntity booking) {
        return repository.saveAndFlush(booking);
    }

    public Optional<CommuterBookingEntity> findByBookingId(Long bookingId) {
        return repository.findByBookingId(bookingId);
    }

    public List<CommuterBookingEntity> findAllByCommuterId(Long commuterId) {
        return repository.findAllByCommuterId(commuterId);
    }

    public List<CommuterBookingEntity> findAllByTruckRouteId(Long truckRouteId) {
        return repository.findAllByTruckRouteId(truckRouteId);
    }

    public List<CommuterBookingEntity> findAllByCommuterIdAndTruckRouteId(Long commuterId, Long truckRouteId) {
        return repository.findAllByCommuterIdAndTruckRouteId(commuterId, truckRouteId);
    }
}
