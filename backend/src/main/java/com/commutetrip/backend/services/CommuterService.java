package com.commutetrip.backend.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.commutetrip.backend.database.services.CommuterDBService;
import com.commutetrip.backend.database.entities.CommuterEntity;
import com.commutetrip.backend.models.Commuter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommuterService {
    private final CommuterDBService service;

    @Autowired
    public CommuterService(CommuterDBService service) {
        this.service = service;
    }

    private Optional<Commuter> mapEntityToModel(Optional<CommuterEntity> commuterEntity) {
        return commuterEntity.map(entity -> new Commuter(
                entity.getCommuterId(),
                entity.getCommuterName(),
                entity.getAwsUserId()
        ));
    }

    public Commuter saveCommuter(Commuter commuter) {
        CommuterEntity savedCommuter = service.saveCommuter(new CommuterEntity(
                commuter.getCommuterName(),
                commuter.getAwsUserId()
        ));
        return new Commuter(
                savedCommuter.getCommuterId(),
                savedCommuter.getCommuterName()
        );
    }

    public List<Commuter> findAllCommuters() {
        return service.findAllCommuters()
                .stream()
                .map(commuterEntity -> new Commuter(
                        commuterEntity.getCommuterId(),
                        commuterEntity.getCommuterName()
                ))
                .collect(Collectors.toList());
    }

    public Optional<Commuter> findCommuter(String name, Long id) {
        if (id != null) {
            return findByCommuterId(id);
        } else if (name != null) {
            return findByCommuterName(name);
        }
        return Optional.empty();
    }

    public Optional<Commuter> findByAwsUserId(Long awsUserId) {
        Optional<CommuterEntity> commuterEntity = service.findByAwsUserId(awsUserId);
        return mapEntityToModel(commuterEntity);
    }

    public Optional<Commuter> findByCommuterName(String name) {
        Optional<CommuterEntity> commuterEntity = service.findByCommuterName(name);
        return mapEntityToModel(commuterEntity);
    }

    public Optional<Commuter> findByCommuterId(Long commuterId) {
        Optional<CommuterEntity> commuterEntity = service.findByCommuterId(commuterId);
        return mapEntityToModel(commuterEntity);
    }
}
