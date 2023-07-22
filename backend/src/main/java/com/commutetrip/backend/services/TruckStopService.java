package com.commutetrip.backend.services;

import com.commutetrip.backend.database.entities.TruckStopEntity;
import com.commutetrip.backend.models.TruckStop;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.commutetrip.backend.database.services.TruckStopDBService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TruckStopService {
    private final TruckStopDBService service;

    private TruckStop mapTruckStop(TruckStopEntity truckStop){
        return new TruckStop(
                truckStop.getStopId(),
                truckStop.getStopLatitude(),
                truckStop.getStopLongitude()
        );
    }
    public TruckStopEntity saveTruckStop(TruckStopEntity truckStop) {
        return service.saveTruckStop(truckStop);
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
