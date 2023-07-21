package com.commutetrip.backend.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
public record Route(Long routeId, TruckStop startingPoint, TruckStop endPoint) {
}
