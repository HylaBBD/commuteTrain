package com.commutetrip.backend.services;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;

import com.commutetrip.backend.database.services.CommuterDBService;
import com.commutetrip.backend.database.entities.CommuterEntity;

import com.commutetrip.backend.models.Commuter;

@RequiredArgsConstructor
@Service
public class CommuterService {
    private final CommuterDBService service;

    private Commuter mapCommuter(CommuterEntity commuter) {
        return new Commuter(
                commuter.getCommuterId(),
                commuter.getCommuterName());
    }

    public Optional<Commuter> findCommuter(String name, Long id) {
        if (id != null) {
            return getCommuter(id);
        } else if (name != null) {
            return findByCommuterName(name)
                    .map(this::mapCommuter);
        }
        return Optional.empty();
    }

    public Commuter saveCommuter(String name, String id) {
        // Call aws to save commuter and get aws_sub_id
        CommuterEntity savedCommuter = service.saveCommuter(new CommuterEntity(
                name,
                id));
        return new Commuter(
                savedCommuter.getCommuterId(),
                savedCommuter.getCommuterName());
    }

    public List<Commuter> findAllCommuters() {
        return service.findAllCommuters()
                .stream().map(this::mapCommuter)
                .collect(Collectors.toList());
    }

    public Optional<CommuterEntity> findByAwsUserId(String awsUserId) {
        return service.findByAwsUserId(awsUserId);
    }

    public Optional<CommuterEntity> findByCommuterName(String name) {
        return service.findByCommuterName(name);
    }

    public Optional<CommuterEntity> findByCommuterId(Long commuterId) {
        return service.findByCommuterId(commuterId);
    }

    public Optional<Commuter> getCommuter(Long commuterId) {
        return findByCommuterId(commuterId)
                .map(this::mapCommuter);
    }
}
