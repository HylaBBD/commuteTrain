package com.commutetrip.backend.database.repositories;

import com.commutetrip.backend.database.entities.EquipmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EquipmentRepository extends JpaRepository<EquipmentEntity, Long> {
    Optional<EquipmentEntity> findByEquipmentId(Long equipmentId);

    List<EquipmentEntity> findALlByName(String name);

    List<EquipmentEntity> findAllByMuscle(String muscle);
}