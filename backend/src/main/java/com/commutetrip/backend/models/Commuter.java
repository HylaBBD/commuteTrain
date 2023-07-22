package com.commutetrip.backend.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Commuter {
    private Long commuterId;
    private String commuterName;
    private Long awsUserId;

    public Commuter(Long commuterId, String commuterName, Long awsUserId) {
        this.commuterId = commuterId;
        this.commuterName = commuterName;
        this.awsUserId = awsUserId;
    }

    public Commuter(String commuterName, Long awsUserId) {
        this.commuterName = commuterName;
        this.awsUserId = awsUserId;
    }

    public Commuter(Long commuterId, String commuterName) {
        this.commuterId = commuterId;
        this.commuterName = commuterName;
    }
}
