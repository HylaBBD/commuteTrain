package com.commutetrip.backend.database.services;

import com.commutetrip.backend.database.entities.EquipmentEntity;
import com.commutetrip.backend.database.repositories.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EquipmentDBService {
    private final EquipmentRepository repository;

    @Autowired
    public EquipmentDBService(EquipmentRepository repository) {
        this.repository = repository;
    }

    public Optional<EquipmentEntity> findByEquipmentId(Long equipmentId) {
        return repository.findByEquipmentId(equipmentId);
    }

    public List<EquipmentEntity> findALlByName(String name) {
        return repository.findALlByName(name);
    }

    public List<EquipmentEntity> findAllByMuscle(String muscle) {
        return repository.findAllByMuscle(muscle);
    }
}
