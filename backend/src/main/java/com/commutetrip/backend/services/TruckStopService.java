package com.commutetrip.backend.services;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;

import com.commutetrip.backend.database.services.TruckStopDBService;
import com.commutetrip.backend.database.entities.TruckStopEntity;

import com.commutetrip.backend.models.TruckStop;

@RequiredArgsConstructor
@Service
public class TruckStopService {
    private final TruckStopDBService service;

    private TruckStop mapTruckStop(TruckStopEntity truckStop){
        return new TruckStop(
                truckStop.getStopId(),
                truckStop.getStopLatitude(),
                truckStop.getStopLongitude(),
                truckStop.getAddress()
        );
    }

    public List<TruckStopEntity> findAllTruckStops() {
        return service.findAllTruckStops();
    }

    public Optional<TruckStopEntity> findByStopId(Long stopId) {
        return service.findByStopId(stopId);
    }

    public Optional<TruckStop> getTruckStop(Long stopId) {
        return findByStopId(stopId).map(this::mapTruckStop);
    }
}
