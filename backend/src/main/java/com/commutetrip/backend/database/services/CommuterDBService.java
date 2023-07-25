package com.commutetrip.backend.database.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.commutetrip.backend.database.repositories.CommuterRepository;
import com.commutetrip.backend.database.entities.CommuterEntity;

@Service
public class CommuterDBService {
    private CommuterRepository repository;

    @Autowired
    public CommuterDBService(CommuterRepository commuterRepository) {
        this.repository = commuterRepository;
    }

    public CommuterEntity saveCommuter(CommuterEntity commuter) {
        return repository.saveAndFlush(commuter);
    }

    public List<CommuterEntity> findAllCommuters() {
        return repository.findAll();
    }

    public Optional<CommuterEntity> findByAwsUserId(String awsUserId) {
        return repository.findByAwsUserId(awsUserId);
    }

    public Optional<CommuterEntity> findByCommuterName(String name) {
        return repository.findByCommuterName(name);
    }

    public Optional<CommuterEntity> findByCommuterId(Long commuterId) {
        return repository.findByCommuterId(commuterId);
    }
}
