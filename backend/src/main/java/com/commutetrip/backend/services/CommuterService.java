package com.commutetrip.backend.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.commutetrip.backend.database.services.CommuterDBService;
import com.commutetrip.backend.database.entities.CommuterEntity;
import com.commutetrip.backend.models.Commuter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CommuterService {
    private final CommuterDBService service;


    public Optional<CommuterEntity> findCommuter(String name, Long id) {
        if (id != null) {
            return findByCommuterId(id);
        } else if (name != null) {
            return findByCommuterName(name);
        }
        return Optional.empty();
    }

    public CommuterEntity saveCommuter(CommuterEntity commuter) {
        return service.saveCommuter(commuter);
    }

    public List<CommuterEntity> findAllCommuters() {
        return service.findAllCommuters();
    }

    public Optional<CommuterEntity> findByAwsUserId(Long awsUserId) {
        return service.findByAwsUserId(awsUserId);
    }

    public Optional<CommuterEntity> findByCommuterName(String name) {
        return service.findByCommuterName(name);
    }

    public Optional<CommuterEntity> findByCommuterId(Long commuterId) {
        return service.findByCommuterId(commuterId);
    }
}
