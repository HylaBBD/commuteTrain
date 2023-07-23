package com.commutetrip.backend.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import com.commutetrip.backend.database.entities.CommuterEntity;

@Repository
public interface CommuterRepository extends JpaRepository<CommuterEntity, Long> {
    Optional<CommuterEntity> findByAwsUserId(Long awsUserId);
    Optional<CommuterEntity> findByCommuterName(String commuterName);
    Optional<CommuterEntity> findByCommuterId(Long commuterId);

}
