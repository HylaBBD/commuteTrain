package com.commutetrip.backend.models;

import lombok.Getter;

@Getter
public record CommuterBooking(Long bookingId, Long commuterId, Commuter commuter, TruckRoute truckRoute) {
}
