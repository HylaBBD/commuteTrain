package com.commutetrip.backend.database.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.commutetrip.backend.database.repositories.CommuterRepository;
import com.commutetrip.backend.database.entities.CommuterEntity;

@Service
public class CommuterService {
    private CommuterRepository repository;

    @Autowired
    public CommuterService(CommuterRepository commuterRepository) {
        this.repository = commuterRepository;
    }

    public CommuterEntity saveCommuter(CommuterEntity commuter) {
        return repository.saveAndFlush(commuter);
    }

    public List<CommuterEntity> findAllCommuters() {
        return repository.findAll();
    }

    public Optional<CommuterEntity> findByAwsUserId(Long awsUserId) {
        return repository.findByAwsUserId(awsUserId);
    }

    public Optional<CommuterEntity> findByCommuterName(String name) {
        return repository.findByCommuterName(name);
    }

    public Optional<CommuterEntity> findByCommuterId(Long commuterId) {
        return repository.findByCommuterId(commuterId);
    }
}
