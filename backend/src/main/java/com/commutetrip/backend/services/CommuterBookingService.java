package com.commutetrip.backend.services;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public CommuterBooking saveBooking(CommuterBookingEntity booking) {
        return mapBooking(commuterBookingDBService.saveBooking(booking));
    }


    private List<CommuterBooking> findAllByCommuterId(Long commuterId) {
        return commuterBookingDBService.findAllByCommuterId(commuterId)
                .stream().map(this::mapBooking)
                .collect(Collectors.toList());
    }

    private List<CommuterBooking> findAllByTruckRouteId(Long truckRouteId) {
        return commuterBookingDBService.findAllByTruckRouteId(truckRouteId)
                .stream().map(this::mapBooking)
                .collect(Collectors.toList());
    }

    private List<CommuterBooking> findAllByCommuterIdAndTruckRouteId(Long commuterId, Long truckRouteId) {
        return commuterBookingDBService.findAllByCommuterIdAndTruckRouteId(commuterId, truckRouteId)
                .stream().map(this::mapBooking)
                .collect(Collectors.toList());
    }

    private List<CommuterBooking> findAllBookings() {
        return commuterBookingDBService.findAllBookings()
                .stream().map(this::mapBooking)
                .collect(Collectors.toList());
    }

    public List<CommuterBooking> findBookings(Long commuterId, Long truckRouteId) {
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
