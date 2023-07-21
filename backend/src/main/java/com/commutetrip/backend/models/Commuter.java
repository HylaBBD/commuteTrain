package com.commutetrip.backend.models;

import lombok.Getter;

@Getter
public record Commuter(Long commuterId, String commuterName) {
}
