package com.commutetrip.backend.models;

import lombok.Getter;


@Getter
public class Commuter {
    private Long commuterId;
    private final String commuterName;
    private final Long awsUserId;

    public Commuter(Long commuterId, String commuterName, Long awsUserId) {
        this.commuterId = commuterId;
        this.commuterName = commuterName;
        this.awsUserId = awsUserId;
    }

    public Commuter(String commuterName, Long awsUserId) {
        this.commuterName = commuterName;
        this.awsUserId = awsUserId;
    }
}
