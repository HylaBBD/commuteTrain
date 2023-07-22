package com.commutetrip.backend.models;

public record Route(Long routeId, TruckStop startingPoint, TruckStop endPoint) {
}
