package com.commutetrip.backend.models;

import lombok.Getter;
import java.sql.Timestamp;

@Getter
public record TruckRoute(Long truckRouteId, Route route, Timestamp pickupTime, Timestamp dropOffTime) {
}
