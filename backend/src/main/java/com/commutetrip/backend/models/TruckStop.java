package com.commutetrip.backend.models;

import lombok.Getter;

@Getter
public record TruckStop(Long stopId, Double stopLatitude, Double stopLongitude) {
}
