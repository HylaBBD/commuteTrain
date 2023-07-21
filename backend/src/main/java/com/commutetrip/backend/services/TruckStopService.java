package com.commutetrip.backend.services;

import com.commutetrip.backend.database.entities.TruckStopEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.commutetrip.backend.database.services.TruckStopDBService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TruckStopService {
    private final TruckStopDBService service;

    public TruckStopEntity saveTruckStop(TruckStopEntity truckStop) {
        return service.saveTruckStop(truckStop);
    }

    public List<TruckStopEntity> findAllTruckStops() {
        return service.findAllTruckStops();
    }

    public Optional<TruckStopEntity> findByStopId(Long stopId) {
        return service.findByStopId(stopId);
    }
}
