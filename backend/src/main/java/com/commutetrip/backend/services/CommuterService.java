package com.commutetrip.backend.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.commutetrip.backend.database.repositories.impl.CommuterRepositoryImpl;
import com.commutetrip.backend.database.entities.CommuterEntity;
import com.commutetrip.backend.models.Commuter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CommuterService {
    private final CommuterRepositoryImpl commuterRepository;

    private Commuter mapCommuter(CommuterEntity commuter){
        return new Commuter(
                commuter.getCommuterId(),
                commuter.getCommuterName()
        );
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

    public Commuter saveCommuter(Commuter commuter) {
        // Call aws to save commuter and get aws_sub_id
        CommuterEntity savedCommuter = commuterRepository.saveCommuter(new CommuterEntity(
                commuter.commuterName(),
                0L
        ));
        return new Commuter(
                savedCommuter.getCommuterId(),
                savedCommuter.getCommuterName()
        );
    }

    public List<Commuter> findAllCommuters() {
        return commuterRepository.findAllCommuters()
                .stream().map(this::mapCommuter)
                .collect(Collectors.toList());
    }

    public Optional<CommuterEntity> findByAwsUserId(Long awsUserId) {
        return commuterRepository.findByAwsUserId(awsUserId);
    }

    public Optional<CommuterEntity> findByCommuterName(String name) {
        return commuterRepository.findByCommuterName(name);
    }

    public Optional<CommuterEntity> findByCommuterId(Long commuterId) {
        return commuterRepository.findByCommuterId(commuterId);
    }

    public Optional<Commuter> getCommuter(Long commuterId){
        return findByCommuterId(commuterId)
                .map(this::mapCommuter);
    }
}
