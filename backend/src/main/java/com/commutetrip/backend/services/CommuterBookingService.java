package com.commutetrip.backend.services;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;

import com.commutetrip.backend.database.services.CommuterBookingDBService;
import com.commutetrip.backend.database.entities.CommuterBookingEntity;

import com.commutetrip.backend.models.Commuter;
import com.commutetrip.backend.models.CommuterBooking;
import com.commutetrip.backend.models.TruckRoute;

@RequiredArgsConstructor
@Service
public class CommuterBookingService {
    private final CommuterBookingDBService commuterBookingDBService;
    private final CommuterService commuterService;
    private final TruckRouteService truckRouteService;

    private CommuterBooking mapBooking(CommuterBookingEntity booking) {
        Optional<TruckRoute> truckRoute = truckRouteService.getTruckRouteById(booking.getTruckRouteId());
        Optional<Commuter> commuter = commuterService.getCommuter(booking.getCommuterId());
        return new CommuterBooking(
                booking.getBookingId(),
                commuter.orElseThrow(),
                truckRoute.orElseThrow()
        );
    }

    public CommuterBookingEntity saveBooking(CommuterBookingEntity booking) {
        return commuterBookingDBService.saveBooking(booking);
    }


    private List<CommuterBookingEntity> findAllByCommuterId(Long commuterId) {
        return commuterBookingDBService.findAllByCommuterId(commuterId);
    }

    private List<CommuterBookingEntity> findAllByTruckRouteId(Long truckRouteId) {
        return commuterBookingDBService.findAllByTruckRouteId(truckRouteId);
    }

    private List<CommuterBookingEntity> findAllByCommuterIdAndTruckRouteId(Long commuterId, Long truckRouteId) {
        return commuterBookingDBService.findAllByCommuterIdAndTruckRouteId(commuterId, truckRouteId);
    }

    private List<CommuterBookingEntity> findAllBookings() {
        return commuterBookingDBService.findAllBookings();
    }

    public List<CommuterBookingEntity> findBookings(Long commuterId, Long truckRouteId) {
        if(commuterId != null && truckRouteId != null) {
            return findAllByCommuterIdAndTruckRouteId(commuterId, truckRouteId);
        } else if (commuterId != null) {
            return findAllByCommuterId(commuterId);
        } else if (truckRouteId != null) {
            return findAllByTruckRouteId(truckRouteId);
        } else {
            return findAllBookings();
        }
    }

    public Optional<CommuterBooking> getBooking(Long bookingId) {
        return commuterBookingDBService.findByBookingId(bookingId)
                .map(this::mapBooking);
    }
}
