package com.commutetrip.backend.models;

public record CommuterBooking(Long bookingId, Commuter commuter, TruckRoute truckRoute) {
}
