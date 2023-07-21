package com.commutetrip.backend.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommuterBooking {
  private Long bookingId;
  private Long commuterId;
  private Long truckRouteId;

  public CommuterBooking(Long commuterId, Long truckRouteId) {
    this.commuterId = commuterId;
    this.truckRouteId = truckRouteId;
  }

  public CommuterBooking(Long bookingId, Long commuterId, Long truckRouteId) {
    this.bookingId = bookingId;
    this.commuterId = commuterId;
    this.truckRouteId = truckRouteId;
  }
}
