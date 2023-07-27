package com.commutetrip.backend.services;

import com.commutetrip.backend.database.entities.EquipmentEntity;
import com.commutetrip.backend.database.services.EquipmentDBService;
import com.commutetrip.backend.models.Equipment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class EquipmentService {
    private final EquipmentDBService equipmentDBService;
    private Equipment mapEquipment(EquipmentEntity equipmentEntity) {
        return new Equipment(
                equipmentEntity.getEquipmentId(),
                equipmentEntity.getName(),
                equipmentEntity.getMuscle()
        );
    }

    public Optional<Equipment> findByEquipmentId(Long equipmentId) {
        return equipmentDBService.findByEquipmentId(equipmentId)
                .map(this::mapEquipment);
    }

    public List<Equipment> findALlByName(String name) {
        return equipmentDBService.findALlByName(name)
                .stream().map(this::mapEquipment)
                .collect(Collectors.toList());
    }

    public List<Equipment> findAllByMuscle(String muscle) {
        return equipmentDBService.findAllByMuscle(muscle)
                .stream().map(this::mapEquipment)
                .collect(Collectors.toList());
    }
}
