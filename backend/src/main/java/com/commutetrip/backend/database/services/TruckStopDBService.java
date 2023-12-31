package com.commutetrip.backend.database.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.commutetrip.backend.database.repositories.TruckStopRepository;
import com.commutetrip.backend.database.entities.TruckStopEntity;

@Service
public class TruckStopDBService {
    private TruckStopRepository repository;

    @Autowired
    public TruckStopDBService(TruckStopRepository repository) {
        this.repository = repository;
    }

    public List<TruckStopEntity> findAllTruckStops() {
        return repository.findAll();
    }

    public Optional<TruckStopEntity> findByStopId(Long stopId) {
        return repository.findByStopId(stopId);
    }
}
