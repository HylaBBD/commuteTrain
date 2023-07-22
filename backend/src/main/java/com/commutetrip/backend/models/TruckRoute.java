package com.commutetrip.backend.models;

import java.sql.Timestamp;

public record TruckRoute(Long truckRouteId, Route route, Timestamp pickupTime, Timestamp dropOffTime) {
}
